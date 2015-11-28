package extra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import CA.CA;
import CA.CAIBA;

public class IterationsToFinishTT {
	final static String solution = 
			"1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 "
//			"1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 "
			
			;

	final static String[] test = new String[]{
		"110011110110011102002210020011200110222002201211202020101212111112120110010120022211012121002220102002211122101102210200100222000212101212110211021210221020210202022211221002112210201212121022020112020200220010120202120112220212210221011022221",
		"211121022021001012110102011122122122222201110101200001222212220122111220001222102122122021122120011112222100100020002111111211211012122022002200020000212120020022220222020122000112020022002211111222202201121022220220101022122021120121022000011",
		"001002021001100121111111011211020222110211000201200101102200021112102122200111220200112102122202100011210210111212212222000220121211221121022012212120211101102100220001221100211112021021011010120000002112221001201211110022021012002000122222200",
		"100120012002200112011100102212210222102021201112202211001100222210120222022022112221000211222001100222110221101202100021111212120202220221221022112211100112021122101212122202102202002000002111120222001020220200102102010021010121022112020221222",
		"212222111021202220022202001021120112022221012111010121010110220020200120000201222022112110111100012211002221211122111021021200101021000001110112000120012011022210011210202012112000211002121022112020100002101112201200001111101000002220002222122",
		"110022101022000101202011110111120122120011000212222000012102121010022001202211212022010221000121012122101010022211220222220210022121211111210112021020211000202220222111012210022020101202210212122002102021002121021011010010021212022100001122122",
		"111121111201011212221122101202001022202221120200121202120011000211120102021020001100210012110011000011000101000112111210000201202020201200220122002002122102220002002101100112020212012000011100120220221122212020111000222200111200111220220010221",
		"211000102020002021222021111222002002010120000100201010021001120220221010111012120112220220202210222121100221021021011210111110100011121011100221222012221211122221122201210100022201211012120012111122120010202210112221100001010122221222022021211",
		"122000121011000021100220202001221001100120201021212002000000202012100001200212201000020101011002120110012121002210210022111112011021222020012110110110020122100011200120222110022022101212121020210000121110212120022022010102121120010111120121122",
		"110110122101020121012011001110001110220200001221010211100000210212201221220101222221020112111120002220112010220111112220201101212022020002201212202200000220002221020212120012210102222010000002000122101220020222120121020120202120012022200202222",
		"221202200111211101110101020210022200012002001010112011002121201012212210110121002101212221200010221210010222100211112111010100100222021221011221212021122001101022112101011210211010012100000022110210101200000020112221211112221201220212111011011",
		"111100011022021122012210002001002112220201210022112201110210121200102112101202200020022211000010200012000100122101012121220211110200212112211211221020000020211022200010102002220101011120202102201220222110011012002100101010010021002202020210012",
		"101102100122112001102021022110100020020000121001000011002122021020021211111101222102121110001220212021000020201210110021221200022100220012021022202021010202002020001101212222201011001022010122011001210121211202002020011212220110101122021201001",
		"110112100222022000112021002012001202220110122200011022111021120101111002211120022012002022202200102100111220001220021020222022001112101220220112022110000021112000000210020220112210010022221200201201112201001011020000110212102001121211222000001",
		"222000222221221010000200022101012200201201001011100112022010112002001011000010022002202110000100112202210111120110211210111011020102101200111200010002110110102100200210220000121020110210000222012020112120000011122102020221220201202221020012221",
		"111220111012212201000100202121002000220121102020220001212212121200221011000001120012101210001201000022000121110221011012002001002202122200121121002102221120200222122002021222211221212212202002010102000200100220212111001020222211202121012221010",
		"121102020120012212001100001112110110010002100112221010011221002022200201011200011102022121001101011112211112002001220120111011220021202200122201120122101100012200012222021121120101022002210101220101220022110102001222010011212120111022100022101",
		"110222221200010100000012210102112202210011112222200211110020220010120121201000012202010010002022101222112000000001222102000201211010200211112122021201221110220010021200001212101011122211122020021000000111000121011001120022222122120120020111210",
		"101121111210222110120220022100121000201211000001211120220012221111022200201200011010022102021120001221212011002022022020220122100111100121221122021120220121120210211220111012211101011211100010220112222021112010101121021121022012110010200220102",
		"100011101020100000002112011122101110221010120112221201220212020010200010010222102012111001000220212212020100020211222220220200201021210200102120000010200200112002121210100201201100210220002200220020201111111011001200012020001211002020122122202",
		"110102111120020210121100102211001200212202201202102110220101201000100110001222201211011211010110200121002102201222012110000000021022211212202220110212102101002112010010000100111211210222212101111201102120211121000212110022211022200202010211002",
		"220000201020011202120000022211222002122122100001211021121011101112202111022022101010020101210020102000100221222000211101200100010211020000002200200011222120020110011121111201000021112100202220120101222221112222001000112121221000222102222000212",
		"220211121001012012112212011211112200221022021100112121010102201100212121121020201002220102112201201221221112100111122201101012022021022102210222121222111211111001122111222022122121101222210110002101111011020220011211222110211210011011120122020",
		"222102122101122212112200101201101021222200012111221101100212210102101112122102010101212212121111220112212202101220221001101211212120110000221111021002121102220022001112022211102021011211021222020012102212110120012220201121022001110112211200200",
		"221000022010002002020022022200121002000002020111212220202102111121110121122101101110202012222022120002021002101222222010111011000200201220012020221002220101021011101001012202011202122201210121012021220102110201000000020222100202200020022220021",
		"220120021202210221021201110121202211021002000222020011112001021000001100111102120120002202001000012121011021020020212212111112122221202121000102010012120101201112220220020202202122200122121110000211012112120022101222212021021120000100121220021",
		"111121121001111200010120011211001202112000110221201120221001102222000111111012110022101010021021011122000000120201002211000010202001020020102000021020110002101111002201222220102212110211021002201111200021122110210101112001002000201222001222012",
		"111211222210012000002012011112201210120200022111201011211200020002101211211211101201201100001202021101201212002210210020100002010112200020110100021202200110212101110001012120111200101000110010021110012011100121211212010020100202202212221110221",
		"020020012011001120220112012020220210100012100220012022220011201121021210022000212020010002220211202220110212200102002212000100110210211001220000022102201022110211202212211221011111121110220101102102212212102121010022001202220110211001201020100",
		"111211110120102121221001222220122211002001201011121112122121122110101002100120220111112101022001112022122100201012120200111211120221112221221012200200022111111110022120212010000210101022102020022122022221101011001220111011222201020011222021020",
		"221222002002120222022000011012202221001021111022212120212220210010021211222102022022010112021221001001102002221022110022221201210102201220020210102020102010101111000022021011210010110222002221020000010100012222201101101010202021201212111010101",
		"221220100001121012222000211211111120020201101001100000210021101022120001202021021001111201001111212201211210011021001111001001220211020011100121012210221020210002122121022011011002221002122100100010222110222110012200111202121012022021112212212",
		"220201121122000101100001002201112201020122100010200201202012020021021212012020221121102200022001201102021012122021220112120210000111001122201100021020212201102022121202111220002120210222011012101112102102202022201001012222111211210122010121011",
		"221212000001012121220221021221100210010202121102000102221101202021111221000212222001102020211100212010022022221101020100021100111211201210112121202000102020002201211202222112201022001000011220011210211010120201022010010222022202012001011020101",
		"222000221020021000222220211222110000121100000012221212121200102211122202120111001122221001021002211212212222222000120011111112212002211220002021020220212222010002002121002010121101202112002111201200002222101022221111222212202210202110000000221",
		"002012102101021120010111201102211121121120110010122210022001201211112202021110220120201010202011210012101111102012101000222122011202202201022122211120120022121021020120012011021010212020020202020221102202021200100210200102110010022120100101100",
		"222221001220022011001000010122222020020212221110022111201210222022021021112202110111021110202010020002011120210110220022220002010001021021021102002120021000012211120110012100111002100102220022002202010001011012002221212211120012200121101221101",
		"200000022200201100102002021121102102120201021122100222122102002102212121200212121200000122210221022121000012121220221112111211102012121021002201212221121212010120210100011200112021001001121122122002102220022212221221002002211121002200022112101",
		"220210101012020121222210112112111122202111012010100012012002020211120200221210121001001111121010100200121200221121002112022111100010200200110010220112201212020000110000200000010220102211202110002110210201000001211001220020000000011100002222122",
		"221211220111212212012012112121122022220011020202110222100200120101012001110001211220200121022022022022121112101111001121022200000202221000002111011200122221120022101112220121220212112000112001010011210221222110120211112000221010102212110220100",
		"112101100112120022110010201200102011010021021120222011212211122120111012110002020120001210020211121210220021002111212020121020112112220021122021200112222111101211211011221010020200022100100202121221222212211121002111201202021000011210111111211",
		"222000012222001022012011212220000211021212221112010101121022102001201002012120022002012020221221212020022120021021011011111010011000102001222001122100022222220101010021022012012120202120012221200222202222002202200122012102011120011112022220021",
		"110122211011112021101020021100110001010110001101011020122001100121002100111000111002020001010011112202021120000210112002000210112000022020212221001110101012021220022110001212021201202202200121120001212122222210010221202021112021212111210100202",
		"220000022211002202000020122102121222011012110222211101000020200022222202022201120202020221010120021210001012211202122112111212212222012010201122020120102201012011000002222121012211222100202210002000201010002021202200022020021021020200202102221",
		"000001100211101200022201000220021222120210211202121000100212000200200101021122010021212010102111220002101002210010220212210202101220020222000000021122121222000211100220220110102222121200220122120220111000211201022222201022221001002211212122111",
		"000012100110110122120121021110210100002112120010021021102200001100122121121012022100012201200111212010210022011220011102202101220101201001221101021021100202101211122101220202002101220212221222112120012220101221201102122222011202200010121122012",
		"112122211210001020001110120220221012220121221021111122021120111010021002021100222002202212202002101002222212202010110220221021022000210020121211000021012100020000100110020021111020212002121022202120010012211121102100120010101222210022202002122",
		"220200020012210122110120200002202200101220111202011011220112211102211001220010011201001012100102222121022200021211121102202111200202101110012122120012212111110002212110100120120110212102202122000021122121110021201011012201112010121100222222122",
		"111110202220200201102102021212220022010210100202020212012200112012120120101011000222000111102000121200221122000200022020100102002010112211110220222120111222000111010202102011102020010212111102002202121012100202111212122001110121102211021211112",
		"222101201221221110002011102000022201120111020211001111012222012212021101120121220000020210100122110202210121121212222022002110212102002002112212200012012102211101201200021110100202020000210201201000001212011022202112001111010110122212212212212",
		"221201121022220210222000012211001021021012222001021210000012110212002121222022000020100022212021012111112211222001121210202102121210122110022210021000221022100221021012122221000222002220201222012221120012221100101201200111110200001101211222111",
		"111120102121010221001001000011111211111000202012022011210020212011020210012022121010112001121001101012012000211002101012110220121101201222221011210202100220212211120002201112012022112200221112011211001000120122022011210201012012021221110221120",
		"122102021221102022102021121212101200221110200210120020022002120221202220020002111122200110021222112122211111111012012022111110110120012212110212122022022012020222012201100000221002200200221102011210002021222002010022021111001120121220120002220",
		"122121220122201012102001100100112010102011211212202120202220220221112211022210012121210210200021221002021120201021121022011011121220002220112201110221210220112022001112202001211111021222210002122222020121011020100220111210102012111212200121001",
		"102202000021122202022010222110222202220000111120001021020121202222010022011020010212022022001102020212000110011011111121111212220110121020221012110022111122222222110200112220110021111220210021121001212110122011101020020121020022011121020020020",
		"110120011202000110012202101111022122000021001021121020122100200222202102002112021221221111222002012211022002221010011000122122020012200211202011212211220201112211122202002220010122100010111102111220100011200020122021202022011200000110100222122",
		"201122110022200202112020102002200211020020010112020210220000102202122200021100122101021022121010020121020222202002221012111211220121000100110101002102001010021222021210222112012121022220010210101110021022001001020011222020202021220120021022121",
		"110011220100110221210120220201100011020021211102122011122220102121211012110120220200110211021022212021011021120011121012211222002220000111021021001222202112100111020121212102101011101020011011010020021220101100002211112101122112012021121101000",
		"220220202011121001000202221021010212221220210020011200222210111222020110000010212020100102210000102210200210120211120022012120010222000221100022020212201121011222011210111012100100212220111120200212001212111012202220222121012120200222111101121",
		"100000002112011020102200022022102012122000222020022002221022121202100120112102110110002022201212022102112212100100200222111112012212020022120020110020022220010101220212012112021110021111200020011122011022111022210120201201221212021200120022221",
		"222000012101022120201001202110002022220120010102022112012001222021011202210010021212202112112112020121122201120211120110111011101110210000001120000001012011200201122101211222212020111100121021100111212101211121000110012211210211200101222222121",
		"221211100020101020100100221002221100210100210200021101002112201120000220212021022101102222011221102000222210112202202100021020101002220110010122012022022201102221011212121122110021021121222020012221010100012010121212021021102120021122012122122",
		"220212120111202220011010120221012220112202210011101212211111221111122120011022212120211100011021221202202220100212110101120022101111010001112121021110201001120210211002120120212210001201211210221020122011210002121220221112101210002210211020010",
		"000020101122022022220001101112212201020101212212120112110122221212012101120022120111112022222010021211110001000100122121102212020221200100210010220211002010220210022122010000200110002122222110022211010000010002021021102000000012022110110112010",
		"112211102221021120010210000010102012202212112221101120020001221010221101101222220021212002020111022020210220221121101102222221120112220121222001220211001010212210101121022222120110100011120022010002020100122120121000222000210222010012121100121",
		"112020121010010210020120021121120021222012212011211212020201112010111200111112122000212102202122000012010000020212002020222222101101012012222112122011202102112212001100101220002022020200101102022201101120221002010012000122200220122121220021120",
		"221212002220210011201112100010220210202021201212222102010122200022110101221210021221221122111212012122002022022000100022221122110021121010000002011211100100211221020220100110111210021200001222100202201220000211122220102220111020121012100011000",
		"221212202111010110011222120010020221011001122010001102012220101022012012011012211220010122112021111110112210021002012202122020102222001212121022221012002010210201020120010021002022011020022122011200120022202021201200200210201120221211010000000",
		"220020020020202111210020102220120112020120002020002000222212210202220211222001020112121000121222201011020201121011011111111110121220011111001220200120000122100021021001002222002102221120122200022201010200112021200202211120010110010102100000001",
		"202000112012120002000000012120001121120122221210011222120100022002011221112101211020102000100010012020200012010022001110111010012100022002102022121010211022001020002000012212022020222210102121011220020100101101220120121001111111220112020120121",
		"222220222200211022112112000000200021002212012010101211021100212000220120202001011001200011210012202200120220201202110201202110001200101120000210102010012001201120200102222222210201222022010012011012021222201020110002020200011001000020000211100",
		"001001221112011222000212112121020110020200211102122122212211000201120221002202020121210010211021002212202222010012222122020110020221212120220200202222001020011200212121112002102100110010202111210010200101202102212200220202212112222201010222211",
		"001211020102222110210002221110100200112001111110200200211210120022010121202101021102002020011111020210010111101011020021221000210021011211010100221221202002101020202000011211020220111202221112021022120210201102011222121211120202210220102221100",
		"112100222020221202121010202100211010200210022221111021211002000221221012110011002001010112121220000210000002210212221121222210212201022121110222110111212101202022000221100022112010202212212122222000022202101202121012211201122222212001110201100",
		"200000122122021020201200000001211122122200010200022111201210101102111101021220100120222022201002022221021022200002001010111010022012200222121021210020211122201202200022021010011022002010121202011111111021121020012201112101122210112122210011121",
		"222020202111011212101010201210001121202222201201000211002020020020010011022001222022012212102000200001100222202212200112111212120020002222011022120122200001111002201000200022101021110222002220210201201122210020212022022221202120100020000210021",
		"222202100212010102012201201012200100011101111202111200112002022011002121020102002220201122022211101001200211102020100100111111202112102200221000021120011220100220101102100212102011220111011222111120202021010200100212021102221201200202022202122",
		"020022012201121001210210121201110021011022002122010121200012112110001122001121012200121020001002201101202222101220020121112022120100021220101021202111210002202110200120012101212000121020222020201001221011221221011001002011200012010222102010220",
		"111101211012110012121000220012110021000101220012102100212012202020120001002212111212221022210201022122120001201102122020222120011022102012200110220012102220021121001012021120000110212100002211111122201002120200121121121022222000212002202212000",
		"220220101000210020111212121000000120122121122001000122221001002102220220002221212221201120102000011200111111212012122012120201110022110210120002012202102020022201000201222012021200101121112012120111111100201112212101000110111200121101212112202",
		"221101100101010221201200210122212001112011100212001222110120122200120112121101001101112001000000212000020111201112012000111201102202020222022220002122012012002012120202201001020210222200121022120121200222120120212201120222121212102110112002202",
		"001000011100000221112022011101100020002101112112120210121101221021021101112000222102212111221222212122120221002011010112222211011122010002021002120211122200212111022011002122211011010012010102101022221201221121222102000220011021200020121201100",
		"101122111121111111202012212112121102202100221002221000121000211010000102210210210101201102110220212101110111220201120200002212022201022222120121000020222111101000200002212121111100221111201102111110210200000121200222221220120202100022000202100",
		"020012022011001220222000120012201210221010222222002010200202021200010101000201010122012201212120121000211101200112120222001221010010022112100002112221222121120221000112200121201012121221011201110220100012222020112122022200121212102111211210201",
		"200202201221100112221202010111111100200000101202021220102000022001002002011211000022002022212120121010010111002012000211022111011012110121201111010122102201222111120102021211110020211211120100112110000011121000120110110100100200122101122002122",
		"221221111112122011200122011201111020122212221112220211012102200101200201112002100100100202110102020100200122002202202010211212222100120001220002102020202210020010020110112121201000122202112020011021211202022121002220120221000101110220022122122",
		"221221102112201111001210012222110011121222001100210100022022101022101101212011012101200220210012001200200011120201212001100010110221101212121202110022121121220120112201101111201112011101210012202022220121102001111200011001102222022010102021111",
		"111111211121010022122210111220111022222200112011010121110111222112122102222102010212001111100212222212200102102200220022200200221222100011011002221220012210000121201122001110011220102101200100221112200121002220202211112222000110201010000110101",
		"120000110000021200200201112002100220222001220000201002211111201010120022000222221202002221101022202011022222020000102020111010020020220010000201120120020022111021221221020121020102101010020020200200121102012222012221000010112221020220222121120",
		"221000021011020022200222101220221010220202011002000121222002020222212202122212121121122010020122202212022111021102200011111210120222220200220212002020001001020010112120110222210110110212020021221212200120101102021002000112202201101012220100221",
		"222000221211020200200021121101122220110101010111112201102000211220000021001022000022120002121121221222200211120122122012111010202020110010122221010021021210020120001022202222202221200010201022021201021022201000102211000110020000022121000211221",
		"221000202012110222110102000021010220122122120012121101200010011210000102020202012012202010021020212211100211202102122011111212122200112010112201010022201100021220102100210101011202001021010121201220002000102200020020101202001222202210022202011",
		"222222022022110121201111121222120200222112020100120122012111212221211120111020112010221011101200112011000121212110101101102101221201020010010220002002102220212021022100201011212122101122200121112010002212201111121111112002222222222222220001000",
		"110101222011020011100012100001221011210110001121022212202012000102020202000221210001010211000000020020210000112222022211111120202010121021111211212122221101022200101112201220211012021000112102200000020201220220120220020020021022011022202021212",
		"220000012022000102001002010121000101111212011220121200002100222022122111122220022012020111221022010012021010200122102011111011121120021022221200100110201022120122002202220202202021202110211100222022121200210101122002001200111222120000020201211",
		"000201010121012101020000110220010112222011001011001120100000001120112002012210012121111202020120102000211101012021110121120002102121221112000110221221100002200220002022221122022220112112112001000201120121202220022111100010200001001111202122120",
		"",
		"",
		"",
		"",





	};

	public static void main(String[] args) {
		ArrayList<Integer> firstS = new ArrayList<Integer>();
		/*	for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.print("{");
				for (int j2 = 0; j2 < test[i][j].length; j2++) {
					System.out.print(test[i][j][j2] + ",");
				}
				System.out.print("}");
			}
			System.out.println();
		}*/
		for (int i = 0; i < test.length; i++) {



			int dimentions = 2; 
			int boardSize = 6;
			int numOfStates = 3;
			int numberOfRuns = 80;
			boolean randomStart = false;
			boolean vonNeumannNeighbourhood = true;

			CA ca = new CA(dimentions, boardSize, numOfStates, randomStart, vonNeumannNeighbourhood);
			ca.useWriter();
			ca.setRules(test[i]);
			ca.start(numberOfRuns);

			try(BufferedReader br = new BufferedReader(new FileReader("src\\CA\\output\\test2.txt"))) {
				String line = br.readLine();
				int iteration = 0;
				//System.out.println(line);
				line = br.readLine();
				while (line != null) {
					if(line.equals(solution)){
						firstS.add(iteration);
						break;
					}
					iteration++;
					line = br.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		double sum = 0;
		System.out.println(firstS);
		System.out.println(firstS.size());
		for (int i = 0; i < firstS.size(); i++) {
			sum += firstS.get(i);	
		}
		System.out.println("Average: " + sum/firstS.size());
		
		//stdev
		System.out.println("StDev: " + stDev(firstS));
		
		
		
	}
	private static double stDev(ArrayList<Integer> set){
		double sum=0, sumMeanSquared = 0;
		double avarage;
		
		for (Integer integer : set) {
			sum+=integer;
		}
		avarage = sum/set.size();
		for (Integer integer : set) {
			sumMeanSquared += Math.pow((integer.doubleValue()-avarage),2);
			//System.out.println(Math.pow((integer.doubleValue()-avarage),2));
		}
		//System.out.println(sumMeanSquared);
		
		return Math.sqrt(sumMeanSquared/set.size());
	}

}
