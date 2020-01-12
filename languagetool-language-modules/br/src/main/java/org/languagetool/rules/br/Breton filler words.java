/* LanguageTool, a natural language style checker 
 * Copyright (C) 2005 Daniel Naber (http://www.danielnaber.de)
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
package org.languagetool.rules.br-FR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.languagetool.AnalyzedTokenReadings;
import org.languagetool.UserConfig;
import org.languagetool.rules.AbstractFillerWordsRule;
 * A rule that gives hints on the use of Breton filler words.
 * The hints are only given when the percentage of filler words per paragraph exceeds the given limit.
 * A limit of 0 shows all used filler words. Direct speech or citation is excluded otherwise. 
 * This rule detects no grammar error but gives stylistic hints (default off).
 * It is based on the Portuguese Filler Words list and the German Filler words list.
 * @author MORVAN Pierre Wani Alan / Wanibzh29
 * @since 06.26.2018

  private static final Set<String> fillerWords = new HashSet<>(Arrays.asList( 
-achu, -bev, -bras, -diaes, -flamm, -frank, -gorre, -junt, -kaer, -kann, -kel, -klokaat, -lous, -meurbet, -net, -par-teilh, -peg, -pik, -pod, -richenn, -sav, -tan, -teilh, -tra, -yenn, 'zo, dezhañ e-unan, ebet, zo, 'benn 'fin, 'bominapl, 'ta, 'toare, 'vat,
hag a c'haller merzhañ, a benn, a bep amzer, a boan, a c'haller degemer, a c'haller implijout, a c'haller pleustriñ, a c'haller toleriñ, a c'haller touch, a c'hiz kozh, a c'hrad, a c'hras vat, a dra wir, a drugarez, a galon, a garg, a gentañ renk, a nevez 'zo,
a skiant, a van da van, a zeiz da zeiz, a-bad, a-baouez, a-barzh nebeud, a-barzh pell, a-barzh-fin ar gont, a-benn ar fin, a-benn bremañ, a-benn ma, a-benn nebeud, a-benn-kaer, a-benn-kas, a-benn, a-bezh, a-blaen, a-blom-kaer, a-bouez bras, a-bred mat,
a-bred-kaer, a-bred, a-bredik, a-bres, a-c'houde, a-c'houdevezh, a-dachadoù, a-dachadoù, a-dailh, a-daol-kaer, a-daol-prim, a-daol-trumm, a-daol, a-dost, a-dra-sur, a-drek, a-drell, a-dreñv, a-dreuz kartier, a-dreuz, a-dro-jouis, a-dro, a-du 'rall, a-du,
a-enep aze, a-faot, a-fet, a-fetepañs, a-fo, a-frip, a-fuilh, a-gendost, a-gent, a-gentaou, a-gentoù, a-gerzh, a-gerzh, a-gevret, a-gorn, a-gozh, a-greiz ma, a-greiz ma, a-greiz pep-tra, a-greiz-holl, a-greiz, a-grenn, a-greñv, a-grip hag a-grap, a-hardi,
a-hed ar wech, a-hend-all, a-herr, a-heul-da-heul, a-heul, a-holl-viskoazh, a-hont, a-ispilh, a-istribilh, a-istribilh, a-izel, a-laer, a-leizh en, a-lev, a-nebeudoù, a-nes kontañ, a-nes, a-nevez tre, a-nevez, a-ouenn, a-reizh, a-renk, a-rezh, a-skign, a-sko,
a-uhel, a-uhel, a-us da, a-us, a-valc'h, a-vann, a-varv, a-vat, a-vent, a-veure, a-viskoazh, a-vod, a-vole, a-vras, a-vremañ, a-walc'h, a-wazhiennadoù, a-zalc'h, a-zetri, a-zevri, a-ziabell, a-ziar, a-zilerc'h, a-zindan, a-zispilh, a-zivout, a-ziwar-dro, a-ziwar,
a-zoare, a-zoare, a-zornadoù, a-zu-hont, abaf, abafus, abalamour da-se eo, abalamour da, abalamour ma, abaoe kozh amzer, abil, abominapl, abred, abretaat, abretoc'h, absolud, absolut, ac'halese, ac'hano, ac'hanta ma, ac'hanta, ac'hubiñ, achantiñ, achu, adal ma,
addont war-wel, adkargañ, adkemer, adlakat 'barzh ar jeu, adlakat er jeu, adleuniañ, adorabl, adroed, adtremen, aes da vaneañ, aes tostaat outañ, aes-kenañ, aes, afiet, aflijet, ag ar c'haerañ, ag ar choaz, ag un eur d'an arall, aket, aketus, akomod, akseptapl,
aktuel, akuitapl, alej, alese, aleshont, algo, algum, alies, amañ da-heul, amañ goude, amañ hag ahont, amañ hag aze, amañ war-lerc'h, amañ, ambrederiañ, ami, amparfal, ampart-fall, ampechet, amplig mat, amzer ruz, amzer vremañ, amzivin, an dalc'h, an darn vrasañ,
an deiz hiziv, an deiz-mañ, an disterañ ma, an disterañ, an diwad, an dra-mañ-tra, an eil hag egile, an eur diwezhañ, an hini gwellañ, an hini wellañ, an neb-mañ-neb, an neb, an noun piv, an tu kreñv gantañ, an tu pe du, an tu-enep, an-dra-se 'zo kaoz, an-dra-se zo kaoz,
anat deoc'h, anat dit, anat, anav, anav, anaveet, anavezet, anavout un, annezañ, anneziñ, anterin, anv mat, anvet mat, anzav, aotreet, ar an tach, ar bed bras, ar c'hiz-hont, ar c'hiz-mañ, ar c'hiz-se, ar c'hiz-se, ar c'hrak ma 'z eo, àr e war, àr e zivout,
ar enep, ar mod-hont, ar mod-mañ, ar mod-se, ar pellañ ma c'haller, ar pep brasañ, ar pep gwashañ, ar pep muiañ, ar peurvuiañ, ar pezh 'zo, ar pezh eo, ar pezh zo, ar re-nes, ar resis, ar stad-hont, ar stad-mañ, ar stad-se, ar stank ma, ar wez-hont, ar wez-mañ,
ar wez-se, ar wez-se, araogiñ, arbennik, arkaik, arnevez, arroud, arvar, asambl gant, asambles gant, asambles, asur, asurement, atav, avat, aveze, avisted, avizet, azaou, aze, azv, bagol, balc'hded, balc'hder, bamiñ, bamus, bec'h, bemdez, benañ, bennaket,
bep a vare, bep an amzer, bep ar c'heit, bep ar mare, bep eur ha bep moned, bepnoz, bepred, bern, berr-ha-berr, berr, berradenn, berrek, bervidik, betek-henn, betek, beuz, beuz, bev, bez', bezañ a-leizh, bezañ berr gant, bezañ diwar, bezañ dleet, bezañ e dalc'h,
bezañ ideet, bezet a vezo, bihan, bihanañ, bihanig, biken, bilen, birviken, biskenn, biskoazh c'hoazh, biskoazh kaeroc'h, biskoazh kement-all, biskoazh-james, biskoazh, blaouac'h, blasa, blaz ar c'hozh warnañ, ble, blein, blim, bliv, blot, blouc'h,
boas, boazamant, boc'h, bouc'h, bouedek, bouilh, bouilhant, bouk, boull, bourrabl, bourrus, bout diar, bout dleet, boutin, braouac'h, bras-bras, brasoc'h, brasoc'h, brasonius, brav-kaer, brav, bravig, bremaik-tuchant, bremaik, bremañ end-eeun, bremañ ma,
bremañ pa, bremañ souden, bremañ-souden-doue, bremañ-souden, bremañ-tuchant, bremañ, bremzont, brevus, brizh e sac'h, brudet, brusk, brutal, buan, bubuig, burev, burlutus, burzhudus, c'hoari ouzh, c'hoarvezout, c'hoazh ur wech, c'hoazh, c'hwek, c'hwister,
c'hwistim, chak, chalmant, chañsus, charmant, chastre, chastres, cheñch ali, cher, cheuc'h, chichant, chom da restañ, d'al liesañ, d'an ampoent ma, d'an ampoent, d'an nebeutañ tout, d'an nebeutañ, d'an nebeutañ, d'ar mare ma komzan, d'ar mare ma, d'ar mare-hont,
d'ar mare-mañ, d'ar mare-mañ, d'ar mare-se, d'ar muiañ posupl, d'ar muiañ, d'ar muiañ, da bep mare, da c'hoarvezout, da c'houde, da c'hoût emañ, da c'houzout eo, da c'houzout, da dal, da dra, da eil, da gentañ holl, da gentañ tout, da gentañ tra, da gentañ-penn,
da gichen, da lavaret eo, da lavaret gwir, da lavaret mat, da neuze, da skouer, da vat, da viken, da welet, da ziouveret, da ziskar an nen, da ziskar unan, da ziwezhañ, da zoujañ, da-gavout, da-geze, da-heul, da-heul, da-vras, da, dag, dak, dalbezh, dalc'h, dalc'hen da,
dalc'hen kont, dalc'het, dalc'hmat, dalc'hus, dam-, damaik, damdost, damdost, daoust ha, daoust ma, daoust pegen, daoust petra, daoust piv, dare, darempred, dargemm, dargemmañ, dargemmek, dargud, darn an dud, darn vuiañ, dav eo, davedekaat, deboch, dedennus, degemerapl,
degemerus, deiz ha deiz, deiz pe zeiz, dele, delikat, den, depoziñ, derc'h, derc'hel da vont, derc'hel, dereat, derveur, desachus, deskrivañ, despegn, despetus, determinañ, dever, devoudañ, devri, dezhañ e-unan, di-, di, diadrek, diadreñv, diaes ober gantañ, diaes-daonet,
diaes-diaes, diaes-ruz, diaes, diaez-du, diakomod, diamzeriet, diantell, diar, diarbennoù, diarvar, diavañs, diawelet, diazez, diazezet, dibaot a wech, dibaot a wezh, dibaot, dibaot, dibaouez, dibar, dibenn, dibilh-kaer, dibilh, diboell, dibosupl, diboutañ, dic'hallus,
dic'hoarzh, dic'hras, dic'hwezet, dichek, didalvoud, didrec'hus, didro-kaer, diehan, dieil, diemsav, difazi, difer, diferañ, difeson, diflastr, diflip, diflukiñ, difonn, difouge, digalonekaus, digalonus, digened, digenvez, diglosiñ, digoll, digompes, digompez,
digor-frank, digor, digouch, diguñvezh, digustum, diharak, dija, dik, dilavaradoe, dilemel, dilerc'h, dilikad, dilikat, dillo, dillos, dinaoniñ, dindan spes, dindan un taol, dinerzh, diogel, diogel, dioutañ e-unan, diouzh a c'hoarvez, diouzh a c'hoarvez,
diouzh ar fallañ, diouzh ar gwellañ, diouzh boaz, diouzh kustum, diouzh ma ve, diouzh ma vez, diouzh ma vo, diouzh ment, diouzhtu-kaer, diouzhtu, dipitus, diraez, diraeziñ, diratous, direfus, direizh, direizhadenn, direndael, diresis, dirested, direster, direzon,
dirunkun, dis-, disammañ, disaotr, diseblant-kaer, disheñvel, diskouez, diskredapl, diskrivañ, diskrog, dislaouen, disoc'h, disoc'hañ, dispar, dispes, dispis, displaen, displeg, displegadur, distag, distan, distank, distanus, distawel, dister a dra, dister,
disterdra, distreiñ da, distreiñ, distro, diuntu, divalaj, divalav, divalavig, diverradur, diverrañ, divigus, diviz, divizadur,
divlot, divoas, divorañ, divrall, diwall mat, diwall, diwalloù, diwar ar fet-hont, diwar ar fet-mañ, diwar ar fet-se, diwar e goust, diwar gaout, diwar neuze, diwar skañv, diwar skañv, diwar vremañ, diwar-bouez, diwar-laez, diwar-lerc'h, diwar, dizall, dizehan,
dizereat, dizingal, dizintrudu, dizonest, dizoubl, dlead, don-meurbet, don, donaet, donoc'h, dont a-wel, dont da benn, dont da wir, dont war-wel, dont, dornet kaer, dornet mat, douetañ, douetañs, douetus, doujoù, dous, dousig, draenek, drailh, drant, drantiz,
drastus, dre ahont, dre amañ, dre anien, dre ar bed bras, dre ar fet-hont, dre ar fet-mañ, dre ar fet-se, dre ar munud, dre ar munut, dre ar seizh avel, dre aze, dre c'hras doue, dre chañs, dre gaer, dre gaerig, dre hir amzer, dre just, dre natur, dre se,
dre skouer, dre voder, dre voneur, dre vras, dre wir, dre zroed, dre-benn, dre-laer, dre-se eo, dre-skouer, dreist an holl, dreist pep tra, dreist-dreist, dreist-goñvor, dreist-lavar, dreist-ordinal, dreist-penn, dreist, drek, dreñv, dres, drilh, droch, droed,
droed, drol, droukkañchus, droukkontant, droukskouerius, du-hont, du-mañ, du-se, dudiañ, dudius, e berr amzer, e berr gomzoù, e darempred gant, e droug, e fin ar gont, e gwir, e kement degouezh 'zo tout, e kement-lec'h tro dro, e kement-lec'h tro-war-dro,
e koulz vat, e mod ebet, e penn-kont, e pep keñver, e pep-lec'h tro war-dro, e pep-lec'h tro-dro, e pep, e se, e-barzh ar gont-se, e-barzh fin ar gont, e-berr gomzoù, e-berr, e-dilerc'h, e-doare, e-doug, e-feson, e-feson, e-giz ma, e-giz ur mekanik, e-giz-hont,
e-giz-mañ, e-giz-se, e-harz, e-keit ma, e-keñver gant, e-kichen, e-kondision ma, e-korf, e-kreiz, e-kreizig-kreiz, e-kroug, e-lec'h, e-leizh, e-maez ar jeu, e-pad ar mare-hont, e-pad ar mare-mañ, e-pad ar mare-se, e-pad, e-pign, e-se, e-skoaz, e-skourr, e-tailh da,
e-tal kichen, e-treuzarbenn, e-tro ma, e-tro, e-unan-kaer, e-unan-penn, ebat, ebet, ec'hon, echu, eeun-hag-eeun, eeun, eforchoù, eil, eksepsion, elese, elfennel, embreg, embregel, emell, emgefre, emgefreek, emglev, emichañs, en adit, en degouezh-hont, en degouezh-mañ,
en degouezh-se, en despet da, en devezh a hiziv, en digor, en e bart e-unan, en e bart e-unan, en e bart e-unan, en e bezh, en e varr, en e ziazez, en em emellañ, en em gavout, en em ober, en em vataat eus, en em velliñ, en enep, en galloud, en gwir, en hevelep amzer,
en holl d'an holl, en holl d'an holl, en hollved, en nespet da, en oad, en tu all da, en tu kontrel, en tu-all, en tu-hont (da), en tu-hont d'ar gerioù, en un doare akstetapl, en un doare avizet, en un doare azasus, en un doare degemerus, en un doare dereat,
en un doare dic'hwezet, en un doare difetis, en un doare difouge, en un doare droch, en un doare enorus, en un doare fetis, en un doare freskik, en un doare fur, en un doare humpl, en un doare iskis, en un doare izeleg, en un doare kontrol-kaer, en un doare modest,
en un doare naturel, en un doare oristal, en un doare plad, en un doare prudant, en un doare reizh mat, en un doare rezonabl, en un doare skañv, en un doare skiantel, en un doare uvel, en un doare, en un ober an dra-hont, en un taol-kont, en un taol, en ur geñver,
en ur mod pe unan all, en ur ober an dra-hont, en ur ober an dra-mañ, en ur ober an dra-se, en ur par berr, en ur serten mod, en ur ziwall, en-dro, en-eeun, en-enep-kaer, en-ere, en-ispilh, en-leal, enebadur, eneberezh, eneberezh, enebiezh, enebiñ, eno, ent derveur,
ent habaskig, ent-pleustrek, ent, enta, entremar, er c'heit-hont, er c'heit-mañ, er c'heit-se, er maez eus ar jeu, er mare ma komzan, er mare ma, er mare-hont, er mare-mañ, er mare-mañ, er mare-mañ, er mare-se, er memes amzer, er memes mare, er penn diwezhañ,
er penn kentañ, er pleustr, er stern-hont, er stern-mañ, er stern-se, er-azas, er-walc'h, erbet, erfin, ergentaoù, erruout, ervat, eskemmer, eskuit, esorc'hiñ, espar, espediant, espleg, estlamm, estlammus, eston, estrañj, eta, etre keuz ha reuz, etre un nebeut, etremar,
etrezek, eürus, eüruzamant, eus a + conjugated verb, eus al lein, eus al leiz, eus an nec'h, eus ar c'haerañ, eus ar c'hentañ, eus kaout, eus un deiz d'egile, eus un deiz d'un all, eus un eur d'ebenn, eus ur penn, euver, evel 'zo dleet, evel a faot, evel ar mor,
evel ar re all, evel eo dleet, evel kustum, evel m'eo dleet, evel zo dleet, evel-evel, evel-henn, evel-just, evel-se bezet graet, evel-seig, evelato, evelkent, evezh, evezhiant, evidon, eviezhiegezh, evit ... ebet, evit afer-se, evit an deizioù, evit ar mare,
evit ar pezh a sell diouzh, evit ar pezh a sell ouzh, evit ar poent, evit ar wech tout, evit ar wech, evit atav, evit biken, evit bremañ, evit bremañ, evit c'hoazh, evit da, evit dezhañ, evit doare, evit gwir, evit kel lo pezh a ra, evit kelo-se, evit ma,
evit poent, evit troc'hañ berr, evit ul lodenn vat, evit ul lodenn vat, evit ul lodenn vras, evit ur gwel, evit-se, evurus, ez reizh, ez wir, ez-eeun, ez-kroug, ez-pign, ez-reizh, eztaoler, fablus, fachus, faezhus, fall, falladenn, fallgontant, fallijenn,
fatadenn, feal, fenoz, ferm, fesonet-fall, fesonet-mat, fesoniñ, fet, fetez, fetis, fichet, fidel, figus, fin, finvezekaat, fiskal kabidan, fiskal, fiziadus, fiziañs, fiziapl, fizius, flak, flour, flu, fonnapl, fonnus, forzh pegement, forzh pehini,
forzh pelec'h, forzh penaos, forzh petra c'hoarvezfe, forzh petra, forzh piv, founnus, fraezh, frañchizenn, frank, fraost, frapadig, frekañs, freskik, fring, fromus, fu, furnezh, gaeoni, gai, gallet, galloud, galloudezh, gallout, gallus, gant ar pal da, gant ma,
gant poan, gant se, gant-se, gel, gellout, get, giz eo dleet, giz m'eo dleet, glan, glan, glein, gloev, goanagiñ, golc'hedek, gorreg, goude holl, goude ma, goude-se, gouelus, goulenn, gourfenn, goustad, govelaj, gras da, gras, gratis, gren, gres, grevus, groñs,
gros, gwageller, gwak, gwalc'hañ, gwalc'hiñ, gwall vat, gwallchañsus, gwallerus, gwazh ha-se, gwech ebet, gwech ha gwech all, gwech pe wech all, gwech pe wech, gwech, gwechadigoù, gwechall, gwechoù zo, gwelaj, gwelapl, gwell, gwellañ, gwellikañ, gwelloc'h,
gwelus, gwelus, gwenvidig, gwevn, gwevr, gwezh ebet, gwezh erbet, gwezhiennoù, gwezhoù 'zo, gwezhoù 'zo, gwezhoù zo, gwir rezon, gwir, gwiridik, gwirieg, gwirion, gwirionez, gwirioù, gwiskamant, gwitibunan, ha c'hoazh, ha c'hoazh, ha c'hwi ivez, ha gwir,
ha kement 'zo, ha kement zo, ha ma, ha mat pell 'zo, ha mat pell zo, ha me ivez, ha n'en deus ket e bar, ha n'haller ket, ha n'oufe bezañ anv ebet dezhañ, ha neuze, ha ni ivez, ha pa, ha petra ken, ha te ivez, habaskig, hag a brou, hag a c'hall,
hag a c'haller touch, hag a dalvez un dra bennak, hag a sinifi un dra bennak, hag all, hag e, hag eñ ivez, hag evelkent, hag he ivez, hag int ivez, hag-all hag-all, hag-eñ ma, hag-eñ, hakr, han-se, hanter muioc'h, hañvad, hañvadur, hañvarenn, harp, harzer, harzerezh,
harzour, harzus, hatoup, hed-ha-hed, hed, hent miliner, hentadurezh, hentiz, heñvel, hep arvar ebet, hep bern, hep e bar, hep ehan, hep ken... met..., hep mar ebet, hep mar erbet, hep mar na marteze, hep mar, hep mui ken, hep penn-bern, hep pouez, hep sañs, hepmuiken,
her, herradig, herrant, herreg, herrek, herrieg, herrus, hervez ar gwel, hervez doare, hervez kont, hervez skouer, hervez, hervezus, heurtadig, heuz, hevelep, heverk, heverzh, hewel, hidus, hini ebet, hinienn, hiroc'h, hiziv an deiz, hiziv, hiziviken, hogen,
hogos da, hogos, hogozik, hollek a-walc'h, hollvedel, hon nesañ kerent, hon nesañ, hudur, humpl, ijinek, illur, implijus, ingal, ingalig, inglod, inkredapl, integralenn, integrelamant, intem, intent ouzh, interesant, inutul, iskis, ispisial, iwin, james, jedet,
jediñ, jeneral, jenial, jentil, just mat, just, justik, kabidan, kaer ken-ken, kaer-kenañ, kaer, kaerat, kaerret, kaezh, kalavern, kalet, kalfichat, kalveziañ, kalz traoù, kalz, kalzig a, kalzig, kamarad, kambonig, kammdro, kammed, kant vloaz, kaout ar gwir,
kaout droad, kaout leizh, kaout urzh da, kaout, kar-nes, kar-tost, kar, karadeg, kargañ, kariad, kas da benn, kasaus, kavaliourez, kazi biken, kazi birviken, kazi biskoazh, kazi gwech ebet, kazi gwezh ebet, kazi jamez, kazi kammed, kazi morse, kazi, kefleuniañ,
keid-all, keit ha, keit hag, keit-ha-keit, keizh, kelc'hiañ, kelc'hiñ, kellies a, kemenañ, kement a, kement ha ma, kement-mañ, kemer poan, kemer, kemm mat etreze, kemm mat, kemm-ouzh-kemm, kemmesk, kempenn, kempennadurezh, kempoell, kempred, ken ... ha tra,
ken aes ha tra, ken dister tra, ken gwir all, ken nemet rak-se, ken pell ma, ken-ha-ken, ken-ken, ken-ken, ken-kenañ, kenañ-ken, kenañ-kenañ, kenañ, kendalc'h, kenderc'hel, keneve, kenkoulz ha, kennebeut, kenoad, kenstag, kenstagus, kentañ a, kentizh ha ma,
kentoù, keñver-ha-keñver, keñver, kerent, kerkent, kerse, ket, keurenn, keuz, keuzius, kevadek, kevan, kevezas, keze, kiadenn, kichennig, kinklenn, kinnig, klask penn, klenk, klet, klev 'ta, klevet diouzh, klevet ouzh unan, klokaat, kloz, klozañ, koant, kofesaat,
kogez, komparisañ, kompes, kompren e-barzh, koñsekañs, kontant, kontroliezh, kordennañ, korn-tro, kornblegenn, korvoiñ, koulskoude, koulz lâret, koulz lavaret, kourz lavaret, kozhik, krai, krak-ha-berr, krak-ha-krenn, krak, kraket, kran, kreiz, kreizennad,
kreizig-kreiz, krenn ha krak, krenn-ha-kras, krenn, krennañ, kreñv, krizañ, krogad, kruel, kudenn, kuit a, kurius, kustum, la, labaskenn, labour-skol, labourus, laez, lakaat da wir, lakaat diaes unan, lakaat en arvar, lakaat war-raok, lakaat, lakaet,
lakaomp, lakat da sevel, lakat dre gomz, lakat dre skriv, lakat kemm mat etre, lamen, lampr, lañchennet, laosk, laoskijenn, laouen, largik, larjik, lark ganti, larkoc'h, lasiad, leal, lec'h, lec'hiadur, ledanoc'h, lein, leinig-lein, lemel diwar,
lemm e spered, lenkr, lent, lerc'h-diwar-lerc'h, lerc'h-ouzh-lerc'h, leun-barr, leun-chek, leun-chouk, leun-tenn, leun, leuniañ, leuriñ, levn, levnenn, levnenn, liant, lies a wech, lies a wezh, lies gwech, lies, liezek, lifre, lijer, linennañ, lintr,
lintrenn, lintret, lintrus, lipr-ha-lipr, lirzin, lisenn, listenn, litous, lizoureg, lod 'zo, lod zo, loial, lojik, lorc'hus, lovr, lufr, lugud, luziadus, luziata, luziet, luzius, ma c'hall, maen, mailhard, major, maksimom, maleruzamant, man, manifest,
manifik, mann, maoutenn, mar plij, mar, marbluñvek, marc'hagn, marc'hamat, mare, marse a-walc'h, marse, marsen a-walc'h, marsen, marteze a-walc'h, marvailh, marvailhus, marzh, marzhek, marzherezh, mat ma, mat-achu, mat, mechañs, meizh, mekanikel, melek,
memes mod, memes, memestra, mennet da, mennet, meno, ment-ouzh-ment, merfeti, merkapl, merzadus, merzhiñ, merzhout, merzhus, mes, met ma, met, meur a hini, meur a, mibin, mignon, mik, mil boanius, mil gemmesk, mil, milzin, milzin, minimom, mistrik, moarvat,
mod-hont, mod-mañ, mod-se, modern, mojennek, momant, mont a-gostez, mont dirak, mont war-raok, morc'hed, mordo, morse, moumon, moumoun, moust, muchañ, muiañ, muioc'h-mui, muioc'h, munudaet, munudek, munudoù, muzuliañ, n'eo ket, n'eus forzh pehini, n'eus forzh pelec'h,
n'eus forzh penaos, n'eus forzh petra, n'eus forzh piv, n'eus ken, n'eus ket ken, n'haller ket depegn, n'ouzon dare, na bezañ, na boud ma, na boud, na bout ha, na petra 'ta, naet, nammet, nann, naturel, ne vern e-menn, ne vern e-pelec'h, ne vern pehini, ne vern pelec'h,
ne vern penaos, ne vern pevare, ne vern piv, ne veur pegoulz, nebeudig, nebeut-ha-nebeud, neblec'h, nec'hañsus, neket hepken, neket, nemedenn, nemetken, nemeur-kaer, nemeur, neoac'h, neoazh, nep piv bennak, nepas, nepell, nepred, neptu, nerzhek, nes da, neseser, neskar,
net ha pizh, net-ha-pizh, netra nemet, netra, netraig, neuze, nevez 'zo, nevez c'hraet, nevez graet, nevez zo, nevez-flamm, nevez-ruz, newazh, nikun, niver, nivl, nompas, normalamant, notapl, o c'houzout, o paouez, o vezañ ma, oadet, ober an dro, ober brav da, ober diouzh ma,
ober diouzh, ober e seizh gwellañ, ober e seizh posupl, ober evezh, ober war-dro, oberiat, okupiñ, onest, onest, ordin, ordinal, ordinal, oristal, otomatek, otomatik, ouesk, ouzhpenn ma, ouzhpenn, ouzhpennañ, p'ez eo gwir, pa 'z eo, pa laran, pa lavaran, pa, pad, padal, padel,
padelezh, padout, padus, pagnog, pakret, paliekaat, pan eo gwir, pan'd eo gwir, paneve, paneved, panevedoc'h, panevedomp, panevedon, panevedor, panevedout, panevetañ, paneveti, paneveto, par-ouzh-par, par, parañ, pare, parfet, partikulier, pas, paseal, patant, patrom, pe anv,
pe da amzer, pe da goulz, pe da vare, pe eur, pe za vare, peadra, pebezh, pec'hedig, pegen nebeud bennak e ve, pegoulz, pell 'zo, pell zo, pellañ, pellig zo, pellik 'zo, pelloc'h, pemdez, pengenniñ, penn-bern, penn-dre-benn, penn-kil-ha-troad, penn-krec'h, penn-nec'h, penn-tre,
penn-trec'h, pennad, peñver, peogwir, pergen, pervezh, perzh, petore, petra bennak ma, petra din-me, petra neuze, peur, peurachuiñ, peuraozañ, peurbad, peurbadel, peurechu, peurechuiñ, peurgas, peurgetket holl, peurgetket, peurglok, peurlavarout, peurliesañ, peurober, peurvat,
peurvuiañ, peurziheñvelaat, peusplaen, peustost, peuzglok, pevare, pevarlamm, pevarlampik, pezh 'zo, pezh a gari, pezh a, pezh eo, pezh mell, pezh zo, pezh-vil, pezh, pezhel, pikol, pikolek, pimpatrom, pinvidik, pismig, pitoaiapl, pitouilh, pitouilheg, pitous, piv bennak, piv din-me,
pizh-ha-pizh, pizh, pizhardenn, plad, plaen-ha-plaen, plaen, plaenañ, plas, pleal gant, plediñ gant, plegenn, pleumpenn, pleustr, pleustrek, pleustrerezh, plijet, poanius, poellek, poellus, poent, pokañ, pompadell, poñsin, portol, post, postek, posupl, pouez, pouezusoc'h, poulsad,
poulzadig, pounner, pourfitiñ, pozet, pozitivel, pragmatik, pratik, pred, predad, predadig, preder, prederiegezh, prellad, prest a-walc'h, prestig a-walc'h, prestik, prezant, prim, prin, prizius, profitañ, pront, prop, propig, provostapl, prudañs, prudant, puilh, pur, put,
ra vo graet, rag-eeun, rak ma, rak se, rak, raktal ma, raktal, rakwelet, ral a wech, ral a wezh, ral, rannet, rat, razh (an dud), re anat, re bar da, re holl, re wir holl, re wir, re-veur, real, regliñ, regulatenn, reiñ e c'houlenn da, reizh mat, reizh, reizhad, reizhañ, reizhek,
reizhoù, reked, rekedig, rekest, reket, rekis, ren-ha-ren, reoliañ, reoliek, resis, resis, resisaat, resisted, resizañ, ret eo, reut, reuziad, rez, rezonabl, riget ma, riget, rik-ha-rik, rik, rip, roud, rouestlus, rouez, rust, sa, sabaturus, sabatus, sachadig, sacher, sankañ tizh,
sañs, sañset, sañsetamant, santad, santet, santimant, saouriñ, sasun, savellañ, se zo kaoz, sebezennus, sebezus, seblant, sed aze, sed emaomp ganti, sede aze, sede trawalc'h, sederadenn, seizeg, seizenneg, sell aze, sellet diouzh, sempl, serc'h, sernañ, serniñ, serten, sertenamant,
sertes, servijer, servijerez, servijour, servijourez, serzh, setu a zo mat neuze, setu aze, setu eno, seul gwech ma, seul taol, seul wech ma, seul, sevel ur gudenn, sevel, sevenet, seveniñ, sezizer, sezizus, sibiliañ, sichant, siet, sifr, silwink, simpa, simpatik, simpl-ha-simpl,
simpl, sinac'h, sirius, skandalus, skañv, skañvig, skizhañ, sklaer, sklaerijennamant, sklent, sko, skodenn, skoemp, skort, skoueriañ, skuizhus, soagn, soagniñ, sof-kont, solut, sonn, sort na weler ken, sort-se, souezhus, soulgresk, soupl, soursi, soursial ouzh, soursius, soursius,
soutil, spernek, spesial, spesifiañ, spis, spiswell, splann, spletiñ, spontus, stabil, stabiliañ, stad e-barzh, stad-hont, stad-mañ, stad-se, stag-ha-stag, stag-ouzh-stag, stank, stankted, stard, start, statudañ, stegnañ, stenn, stennañ, stignañ, stlenn, strafuilhus, strapennañ,
striv, strizh, strobinellañ, strobus, stroll, stronk, strudus, strujus, sur a-walc'h, sur-mat, suramant, surtout, sustañsus, tabou, tachad, tachadig, tailhañ, takad, talarat, talvezout, tamm ebet, tamm erbet, tamm tout ebet, tamm tout erbet, tammig-ha-tammig, tanav, taol evit taol,
taol ha taol, taol, taolenniñ, taoler evezh, taolit evezh, tarin, tartous, temz, tener, tenn enep, ter, termenapl, termenet, termeniñ, terrupl, teuk, tik, timat, tinell, togn, tolerapl, tonius, tonket, torosennek, torrus, tost biken, tost birviken, tost biskoazh, tost da vat,
tost gwech ebet, tost gwezh ebet, tost james, tost kammed, tost morse, tost-ha-tost, tost-ha-tost, tost-tre, tost, tostik-tost, tostkar, toull, tout, tra gaer a, tra ma, tra pe dra, tra-mañ-tra, tra-penn, tra, tra, tramailh, traoù 'zo, traoù zo, trawalc'h, tre da, tre ha tre,
tre-ha-tre, tre, tre, trec'h da, treilh, trellus, trema, tremen, tremp, treuflez, treuz, treuzwelus, trist, tristik, tro-distro, tro-dro, tro-gorn, tro-ha-tro, tro-war-dro, tro, troad ouzh troad, troiad, tru, trubuilhus, trueg, truezeg, truezus, trugarekaat, tu enep, tu pe du,
tu-adreñv, tu, tud 'zo, tud zo, tudigoù, tuig ha talig, uhel mat, uhel-kaer, uhel-mat, uheloc'h, uhelskouer, uhelvennad, ul lodenn vat, un disterdra, un disterig, un dra anav, un dra bennak, un druez, un eurtad, un netraig, un niver bras a, un tamm mat a, un tamm mat, un tammig,
unan a zaou, unan all c'hoazh, unan all, unan hag unan, unanet, unneuziekaat, unvan, unvan, unvanidigezh, unwisk, unwiskoù, ur bam, ur brav da arvestal, ur brav, ur c'hrenn, ur gwall, ur marzh, ur pe zeiz, ur pennad amzer, ur pezh mell, ur poulsad, ur sav-kalon, ur serten niver,
ur seurt, ur sort, ur viken, ur wech adarre, ur wech an amzer, ur wech ar mare, ur wech ar mare, ur wech c'hoazh, ur wech dre vare, ur wech ouzhpenn, ur wezh an amzer, ur wezh ar mare, ur wezh dre vare, urlu, uvel, veilhañ, vertuzius, vil, vilbezh, vilenaj, vilez, vostapl,
war a seblant, war al lec'h, war an ampl, war an tachad, war an taol, war an tomm, war e ... e-unan, war e blaen, war e blaen, war e bouez, war e bouezig, war e reizh, war e souchig, war e strakig, war enep, war evezh, war greiz, war sujed an, war var, war varteze,
war vete goût, war-bouez nebeud, war-bouez nebeud, war-bouez netra, war-bouez un netra, war-dal, war-dreñv, war-dro, war-du, war-eeun, war-greiz, war-gresk, war-hed, war-lerc'h ma, war-lerc'h, war-varr, war-vete nebeud, war-wel, war-zu, well-wazh, wellañ, ya da, yac'h,
yael, youleg, youlegezh, zokennoc'h, zokenoc'h,

 ));
  
  public BretonFillerWordsRule(ResourceBundle messages, UserConfig userConfig) {
    super(messages, userConfig);
  }

  @Override
  public String getId() {
    return RULE_ID + _BR-FR;
  }

  @Override
  protected boolean isFillerWord(String token) {
    return fillerWords.contains(token);
  }

  @Override
  public boolean isException(AnalyzedTokenReadings[] tokens, int num) {
    if (mas.equals(tokens[num].getToken()) && num >= 2 && ,.equals(tokens[num - 2].getToken())) {
      return true;
    }
    return false;
  }
  
}