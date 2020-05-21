/* LanguageTool, a natural language style checker
 * Copyright (C) 2019 Sohaib Afifi, Taha Zerrouki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.tagging.ar;

import morfologik.stemming.DictionaryLookup;
import morfologik.stemming.IStemmer;
import org.jetbrains.annotations.Nullable;
import org.languagetool.AnalyzedToken;
import org.languagetool.AnalyzedTokenReadings;
import org.languagetool.language.Arabic;
import org.languagetool.tagging.BaseTagger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @since 4.8
 */
public class ArabicTagger extends BaseTagger {
  
  private ArabicTagManager tagmanager= new ArabicTagManager();
  public ArabicTagger() {
    super("/ar/arabic.dict", new Locale("ar"));
  }


  @Override
  public List<AnalyzedTokenReadings> tag(List<String> sentenceTokens) {
    List<AnalyzedTokenReadings> tokenReadings = new ArrayList<>();
    IStemmer dictLookup = new DictionaryLookup(getDictionary());
    int pos = 0;
    for (String word : sentenceTokens) {
      List<AnalyzedToken> l = new ArrayList<>();
      String striped = word.replaceAll("[" + Arabic.TASHKEEL_CHARS + "]", "");
      List<AnalyzedToken> taggerTokens = asAnalyzedTokenListForTaggedWords(word, getWordTagger().tag(striped));
      addTokens(taggerTokens, l);
      // additional tagging with prefixes
      // if not a stop word add more stemming
      if (!isStopWord(taggerTokens)) {
        // test all possible tags
        addTokens(additionalTags(striped, dictLookup), l);
      }
      if (l.isEmpty()) {
        l.add(new AnalyzedToken(word, null, null));
      }
      tokenReadings.add(new AnalyzedTokenReadings(l, pos));
      pos += word.length();
    }
    return tokenReadings;
  }

  @Nullable
  protected List<AnalyzedToken> additionalTags(String word, IStemmer stemmer) {
    List<AnalyzedToken> additionalTaggedTokens = new ArrayList<>();
    List<Integer> prefix_index_list = getPrefixIndexList(word);
    List<Integer> suffix_index_list = getSuffixIndexList(word);

    for (int i : prefix_index_list) {
      for (int j : suffix_index_list) {
        // avoid default case of returned word as it
        if ((i == 0) && (j == word.length()))
          continue;
        // get stem return a list, to generate some variants for stems.
        List<String> stemsList = getStem(word, i, j);
        List<String> tags = getTags(word, i);

        for (String stem : stemsList) {
          List<AnalyzedToken> taggerTokens;
          taggerTokens = asAnalyzedTokenList(stem, stemmer.lookup(stem));

          for (AnalyzedToken taggerToken : taggerTokens) {
            String posTag = taggerToken.getPOSTag();
            // modify tags in postag, return null if not compatible
            posTag = tagmanager.modifyPosTag(posTag, tags);

            if (posTag != null)
              additionalTaggedTokens.add(new AnalyzedToken(word, posTag, taggerToken.getLemma()));
          } // for taggerToken
        } // for stem in stems
      } // for j
    } // for i
    return additionalTaggedTokens;
  }

  private void addTokens(List<AnalyzedToken> taggedTokens, List<AnalyzedToken> l) {
    if (taggedTokens != null) {
      l.addAll(taggedTokens);
    }
  }


  private List<Integer> getSuffixIndexList(String possibleWord) {
    List<Integer> suffix_indexes = new ArrayList<>();
    suffix_indexes.add(possibleWord.length());
    int suffix_pos = possibleWord.length();
    if (possibleWord.endsWith("ك")
      || possibleWord.endsWith("ها")
      || possibleWord.endsWith("هما")
      || possibleWord.endsWith("كما")
      || possibleWord.endsWith("هم")
      || possibleWord.endsWith("هن")
      || possibleWord.endsWith("كم")
      || possibleWord.endsWith("كن")
      || possibleWord.endsWith("نا")
    ) {
      if (possibleWord.endsWith("ك"))
        suffix_pos -= 1;
      else if (possibleWord.endsWith("هما") || possibleWord.endsWith("كما"))
        suffix_pos -= 3;
      else
        suffix_pos -= 2;
      suffix_indexes.add(suffix_pos);
    }
    return suffix_indexes;
  }

  private List<Integer> getPrefixIndexList(String possibleWord) {
    List<Integer> prefix_indexes = new ArrayList<>();
    prefix_indexes.add(0);
    int prefix_pos = 0;
    // three letters
    // two letters


 /*   if (possibleWord.startsWith("و") || possibleWord.startsWith("ف")) {
      possibleWord = possibleWord.replaceAll("^[وف]", "");
      prefix_pos += 1;
      prefix_indexes.add(prefix_pos);
    }*/
    // for letters
    if (possibleWord.startsWith("وكال")
      ||possibleWord.startsWith("وبال")
      ||possibleWord.startsWith("فكال")
      ||possibleWord.startsWith("فبال")
    ) {
      prefix_pos = 4;
      prefix_indexes.add(prefix_pos);
    }
    // three letters
    if (possibleWord.startsWith("ولل") // هذه حالة ول+ال
      || possibleWord.startsWith("فلل")
      || possibleWord.startsWith("فال")
      || possibleWord.startsWith("وال")
      || possibleWord.startsWith("بال")
      || possibleWord.startsWith("كال")
    ) {
      prefix_pos = 3;
      prefix_indexes.add(prefix_pos);
    }
    // two letters
    if (possibleWord.startsWith("لل")  // حالة ل+ال أي حرفان زائدان
      ||possibleWord.startsWith("وك")
      ||possibleWord.startsWith("ول")
      ||possibleWord.startsWith("وب")
      ||possibleWord.startsWith("فك")
      ||possibleWord.startsWith("فل")
      ||possibleWord.startsWith("فب")
      ||possibleWord.startsWith("ال")
      //  حالة الفعل المضارع، السين فقط ما يؤخذ
      ||possibleWord.startsWith("فسأ")
      || possibleWord.startsWith("فسن")
      || possibleWord.startsWith("فسي")
      || possibleWord.startsWith("فست")
      ||possibleWord.startsWith("وسأ")
      || possibleWord.startsWith("وسن")
      || possibleWord.startsWith("وسي")
      || possibleWord.startsWith("وست")

    ) {
      prefix_pos = 2;
      prefix_indexes.add(prefix_pos);
    }
    // one letter
    if (possibleWord.startsWith("ك")
    ||possibleWord.startsWith("ل")
    ||possibleWord.startsWith("ب")
    ||possibleWord.startsWith("و")
    ||possibleWord.startsWith("ف")
      ||possibleWord.startsWith("سأ")  //  حالة الفعل المضارع، السين فقط ما يؤخذ
      || possibleWord.startsWith("سن")
      || possibleWord.startsWith("سي")
      || possibleWord.startsWith("ست")
    ) {
      prefix_pos = 1;
      prefix_indexes.add(prefix_pos);
    }

    // get prefixe
    return prefix_indexes;
  }


  private List<String> getTags(String word, int posStart) {
    List<String> tags = new ArrayList<>();
    // extract tags from word
    String prefix = getPrefix(word, posStart);
    // prefixes
    // first place
    if (prefix.startsWith("و") || prefix.startsWith("ف")) {
      tags.add("W");
      prefix = prefix.replaceAll("^[وف]", "");

    }
    // second place
    if (prefix.startsWith("ك")) {
      tags.add("K");
    } else if (prefix.startsWith("ل")) {
      tags.add("L");
    } else if (prefix.startsWith("ب")) {
      tags.add("B");
    } else if (prefix.startsWith("س")) {
      tags.add("S");
    }
    // last place
    if (prefix.endsWith("ال")
      ||prefix.endsWith("لل")
    ) {
      tags.add("D");
    }
    // suffixes
    // TODO if needed
    return tags;
  }

//   private String modifyPosTag(String postag, List<String> tags) {
//     // if one of tags are incompatible return null
// 
//     for (String tg : tags) {
//       postag = addTag(postag, tg);
//       if (postag == null)
//         return null;
//     }
//     return postag;
//   }

//   /* Add the flag to an encoded tag */
//   public String addTag(String postag, String flag) {
//     StringBuilder tmp = new StringBuilder(postag);
//     if (flag.equals("W")) {
//       tmp.setCharAt(postag.length() - 3, 'W');
//     } else if (flag.equals("K")) {
//       if (postag.startsWith("N")) {
//         // the noun must be majrour
//         if (isMajrour(postag))
//           tmp.setCharAt(postag.length() - 2, 'K');
//           // a prefix K but non majrour
//         else return null;
// 
//       } else return null;
//     }  else if (flag.equals("B")) {
//       if (postag.startsWith("N")) {
//         // the noun must be majrour
//         if (isMajrour(postag))
//           tmp.setCharAt(postag.length() - 2, 'B');
//           // a prefix B but non majrour
//         else return null;
// 
//       } else return null;
//     } else if (flag.equals("L")) {
//       if (isNoun(postag)) {
//         // the noun must be majrour
//         if (isMajrour(postag))
//           tmp.setCharAt(postag.length() - 2, 'L');
//           // a prefix Lam but non majrour
//         else return null;
// 
//       } else {// verb case
//         tmp.setCharAt(postag.length() - 2, 'L');
//       }
//     }
//         else if (flag.equals("D")) {
//         // the noun must be not attached
//         if (isUnAttachedNoun(postag))
//           tmp.setCharAt(postag.length() - 1, 'L');
//           // a prefix Lam but non majrour
//         else return null;
//     } else if (flag.equals("S")) {
//       // َAdd S flag
//       // if postag contains a future tag, TODO with regex
//       if (isFutureTense(postag)) {
//         tmp.setCharAt(postag.length() - 2, 'S');
//       } else
//         // a prefix Seen but non verb or future
//         return null;
//     }
//     return tmp.toString();
//   }

//   private boolean isMajrour(String postag) {// return true if have flag majrour
//     return (postag.charAt(6) == 'I') || (postag.charAt(6) == '-');
//   }
//   private boolean isNoun(String postag) {// return true if have flag noun
//     return postag.startsWith("N");
//   }
//   private boolean isVerb(String postag) {// return true if have flag verb
//     return postag.startsWith("V");
//   }
// 
//   private boolean isFutureTense(String postag) {// return true if have flag future
//     return postag.startsWith("V") && postag.contains("f");
//   }
// 
//   private boolean isUnAttachedNoun(String postag) {// return true if have flag is noun and has attached pronoun
//     return postag.startsWith("N") && !postag.endsWith("H");
//   }

  // test if word has stopword tagging
  private boolean isStopWord(List<AnalyzedToken> taggerTokens) {
   // if one token is stop word
  for (AnalyzedToken tok : taggerTokens) {
      if (tagmanager.isStopWord(tok.getPOSTag()))
        return true;
    }
    return false;
  }

  private String getPrefix(String word, int pos) {
    // get prefixe
    return word.substring(0, pos);
  }

  private List<String> getStem(String word, int posStart, int posEnd) {
    // get prefixe
    // extract only stem+suffix, the suffix ill be replaced by pronoun model
    List<String> stemList = new ArrayList<>();
    String stem = word.substring(posStart);
    if (posEnd != word.length()) { // convert attached pronouns to one model form
      stem = stem.replaceAll("(ك|ها|هما|هم|هن|كما|كم|كن|نا|ي)$", "ه");
    }
    // correct some stems
    // correct case of للاسم
    String prefix = getPrefix(word, posStart);
    if (prefix.endsWith("لل")) {
      stemList.add("ل" + stem); // للاعب => لل- لاعب
    }
    /*    if (prefix.endsWith("ل") && stem.startsWith("ل")) {
      //stem = "ا"+stem;
      stemList.add("ا" + stem); // للأسم => ل+الاسم
      stemList.add("ال" + stem); // للاعب => ل+اللاعب
    }*/
    // always
    stemList.add(stem);  // لاسم أو ل+لاعب
    return stemList;
  }
}

