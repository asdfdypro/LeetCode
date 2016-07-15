package asdf.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

	/**
	 * (单词变换数目) Given two words (beginWord and endWord), and a dictionary's word
	 * list, find all shortest transformation sequence(s) from beginWord to
	 * endWord, such that:
	 * 
	 * 1.Only one letter can be changed at a time
	 * 
	 * 2.Each intermediate word must exist in the word list
	 * 
	 * For example,
	 * 
	 * Given: beginWord = "hit" endWord = "cog" wordList =
	 * ["hot","dot","dog","lot","log"]
	 * 
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->
	 * "cog",
	 * 
	 * Return: 5
	 * 
	 * Note:
	 * 
	 * Return 0 if there is no such transformation sequence.
	 * 
	 * All words have the same length.
	 * 
	 * All words contain only lowercase alphabetic characters.
	 */
	// 广搜 按字母搜索
	//注意每层过后才能标记不可达
	//记录访问点比删除更快，但只能用于数目计算，可能出现A-B-C A-D-C

	//AC 128ms
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		int res = 0;
		int wordLength = beginWord.length();	
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);	
		
		
		Queue<String> newQueue;
		Set<String> visited = new HashSet<>();// 每完成一层，减少检索单词
		String word;
		int d;
		String newWord;
		char[] cc;
		char old;		
		do{
			newQueue = new LinkedList<>();		
			while (!queue.isEmpty()) {
				word = queue.poll();
				d = wordDistance(word, endWord, wordLength);
				if (d < 2) {// 结束
					return res + d + 1;
				} else if (newQueue != null) {// 向下搜索
					cc = word.toCharArray();
					for (int i = 0; i < wordLength; i++) {
						old = cc[i];
						for (char j = 'a'; j <= 'z'; j++) {
							cc[i] = j;
							newWord = new String(cc);
							if (!visited.contains(newWord) && wordList.contains(newWord)) {
								visited.add(newWord);
								newQueue.offer(newWord);
							}
						}
						cc[i] = old;
					}
				}
			}
			queue = newQueue;				
				res++;			
		}while(newQueue != null && newQueue.size() > 0);
		
		return 0;
	}


	/**
	 * 单词距离
	 */
	private int wordDistance(String w1, String w2, int wordLength) {
		int d = 0;
		for (int i = 0; i < wordLength; i++) {
			if (w1.charAt(i) != w2.charAt(i))
				d++;
			if (d > 1)
				break;
		}
		return d;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		// String beginWord = "hit";
		// String endWord = "cog";
		// String[] words = { "hot", "dot", "dog", "lot", "log" };

		// 包含首元素
		// String beginWord = "hit";
		// String endWord = "cog";
		// String[] words = { "hot","cog","dot","dog","hit","lot","log"};

		// 不同路径上，同一个单词的前驱可能相同
		// String beginWord = "red";
		// String endWord = "tax";
		// String[] words = { "ted", "tex", "red", "tax", "tad", "den", "rex",
		// "pee" };

		// 没有结果
//		 String beginWord = "hot";
//		 String endWord = "dog";
//		 String[] words = { "hot", "dog" };

		// String beginWord = "qa";
		// String endWord = "sq";
		// String[] words = { "si", "go", "se", "cm", "so", "ph", "mt", "db",
		// "mb", "sb", "kr", "ln",
		// "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to",
		// "ra", "fa", "yo",
		// "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn",
		// "au", "ur", "rh",
		// "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge",
		// "th", "pm", "rb",
		// "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa",
		// "pi", "os", "uh",
		// "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn",
		// "mi", "am", "ex",
		// "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr",
		// "sq", "ye" };

//		String beginWord = "cet";
//		String endWord = "ism";
//		String[] words = { "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay",
//				"sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die",
//				"war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid",
//				"ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag",
//				"yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw",
//				"out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy",
//				"fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry",
//				"tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed",
//				"non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap",
//				"owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax",
//				"hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm",
//				"lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew",
//				"wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron",
//				"soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but",
//				"orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew",
//				"web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib",
//				"rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev",
//				"jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin",
//				"fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus",
//				"oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six",
//				"ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap",
//				"lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue",
//				"thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec",
//				"ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw",
//				"nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow",
//				"cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum",
//				"hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet",
//				"gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur",
//				"ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw",
//				"wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our",
//				"ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui",
//				"yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug",
//				"toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay",
//				"pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim",
//				"pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw",
//				"eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid",
//				"pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub",
//				"low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban",
//				"flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net",
//				"tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic",
//				"ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism",
//				"err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa",
//				"min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh",
//				"ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut",
//				"she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape",
//				"rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref",
//				"aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win",
//				"tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob",
//				"mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox",
//				"vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten",
//				"mob" };

		 /*
		String beginWord = "charge";
		String endWord = "comedo";
		String[] words = { "shanny","shinny","whinny","whiney","shiver","sharer","scarer","scaler","render","fluxes","teases","starks","clinks","messrs","crewed","donner","blurts","bettye","powell","castes","hackee","hackle","heckle","deckle","decile","defile","define","refine","repine","rapine","ravine","raving","roving","chased","roping","coping","coming","homing","pointy","hominy","homily","homely","comely","comedy","comedo","vagues","crocus","spiked","bobbed","dourer","smells","feared","wooden","stings","loafer","pleads","gaiter","meeter","denser","bather","deaves","wetted","pleats","cadger","curbed","grover","hinged","budget","gables","larked","flunks","fibbed","bricks","bowell","yonder","grimes","clewed","triads","legion","lacier","ridden","bogied","camper","damien","spokes","flecks","goosed","snorer","choked","choler","leakey","vagued","flumes","scanty","bugger","tablet","nilled","julies","roomed","ridges","snared","singes","slicks","toiled","verged","shitty","clicks","farmed","stunts","dowsed","brisks","skunks","linens","hammer","naiver","duster","elates","kooked","whacky","mather","loomed","soured","mosses","keeled","drains","drafty","cricks","glower","brayed","jester","mender","burros","arises","barker","father","creaks","prayed","bulges","heaped","called","volley","girted","forded","huffed","bergen","grated","douses","jagger","grovel","lashes","creeds","bonier","snacks","powder","curled","milker","posers","ribbed","tracts","stoked","russel","bummer","cusses","gouged","nailed","lobbed","novels","stands","caches","swanks","jutted","zinged","wigged","lunges","divers","cranny","pinter","guides","tigers","traces","berber","purges","hoaxer","either","bribed","camped","funked","creaky","noises","paused","splits","morrow","faults","ladies","dinged","smoker","calved","deters","kicker","wisher","ballad","filled","fobbed","tucker","steams","rubber","staled","chived","warred","draped","curfew","chafed","washer","tombed","basket","limned","rapped","swills","gashed","loaner","settee","layers","bootee","rioted","prance","sharps","wigner","ranted","hanker","leaden","groped","dalian","robbed","peeled","larder","spoofs","pushed","hallie","maiden","waller","pashas","grains","pinked","lodged","zipper","sneers","bootie","drives","former","deepen","carboy","snouts","fained","wilmer","trance","bugles","chimps","deeper","bolder","cupped","mauser","pagers","proven","teaser","plucky","curved","shoots","barged","mantes","reefer","coater","clotho","wanner","likens","swamis","troyes","breton","fences","pastas","quirky","boiler","canoes","looted","caries","stride","adorns","dwells","hatred","cloths","rotted","spooks","canyon","lances","denied","beefed","diaper","wiener","rifled","leader","ousted","sprays","ridged","mousey","darken","guiled","gasses","suited","drools","bloody","murals","lassie","babied","fitter","lessee","chiles","wrongs","malian","leaves","redder","funnel","broths","gushes","grants","doyens","simmer","locked","spoors","berger","landed","mosley","scorns","whiten","hurled","routed","careen","chorus","chasms","hopped","cadged","kicked","slewed","shrewd","mauled","saucer","jested","shriek","giblet","gnarls","foaled","roughs","copses","sacked","blends","slurps","cashew","grades","cramps","radius","tamped","truths","cleans","creams","manner","crimps","hauled","cheery","shells","asters","scalps","quotas","clears","clover","weeder","homers","pelted","hugged","marked","moaned","steely","jagged","glades","goshes","masked","ringer","eloped","vortex","gender","spotty","harken","hasten","smiths","mulled","specks","smiles","vainer","patted","harden","nicked","dooley","begged","belief","bushel","rivers","sealed","neuter","legged","garter","freaks","server","crimea","tossed","wilted","cheers","slides","cowley","snotty","willed","bowled","tortes","pranks","yelped","slaved","silver","swords","miners","fairer","trills","salted","copsed","crusts","hogged","seemed","revert","gusted","pixies","tamika","franks","crowed","rocked","fisher","sheers","pushes","drifts","scouts","sables","sallie","shiner","coupes","napped","drowse","traced","scenes","brakes","steele","beater","buries","turned","luther","bowers","lofted","blazer","serves","cagney","hansel","talker","warmed","flirts","braced","yukked","milken","forged","dodder","strafe","blurbs","snorts","jetted","picket","pistil","valved","pewter","crawls","strews","railed","clunks","smiled","dealer","cussed","hocked","spited","cowers","strobe","donned","brawls","minxes","philby","gavels","renter","losses","packet","defied","hazier","twines","balled","gaoled","esther","narrow","soused","crispy","souped","corned","cooley","rioter","talley","keaton","rocker","spades","billie","mattel","billet","horton","navels","sander","stoker","winded","wilder","cloyed","blazed","itched","docked","greene","boozed","ticket","temped","capons","bravos","rinded","brandi","massed","sobbed","shapes","yippee","script","lesion","mallet","seabed","medals","series","phases","grower","vertex","dented","tushed","barron","toffee","bushes","mouser","zenger","quaked","marley","surfed","harmed","mormon","flints","shamed","forgot","jailor","boater","sparer","shards","master","pistol","tooted","banned","drover","spices","gobbed","corals","chucks","kitten","whales","nickel","scrape","hosted","hences","morays","stomps","marcel","hummed","wonder","stoves","distil","coffer","quaker","curler","nurses","cabbed","jigger","grails","manges","larger","zipped","rovers","stints","nudges","marlin","exuded","storey","pester","longer","creeps","meaner","wallop","dewier","rivera","drones","valued","bugled","swards","cortes","charts","benson","wreaks","glares","levels","smithy","slater","suites","paired","fetter","rutted","levied","menses","wither","woolly","weeded","planed","censer","tested","pulled","hitter","slicer","tartar","chunky","whirrs","mewled","astern","walden","hilton","cached","geller","dolled","chores","sorter","soothe","reused","clumps","fueled","hurler","helled","packed","ripped","tanned","binder","flames","teased","punker","jerked","cannon","joists","whited","sagged","heaven","hansen","grayer","turfed","cranks","stater","bunted","horsey","shakes","brands","faints","barber","gorged","creamy","mowers","scrams","gashes","knacks","aeries","sticks","altars","hostel","pumped","reeves","litter","hoaxed","mushed","guided","ripper","bought","gelled","ranker","jennie","blares","saloon","bomber","mollie","scoops","coolie","hollis","shrunk","tattle","sensed","gasket","dodoes","mapped","strips","dodges","sailed","talked","sorted","lodges","livest","pastel","ladles","graded","thrice","thales","sagger","mellon","ganged","maroon","fluked","raised","nannie","dearer","lither","triked","dorset","clamps","lonnie","spates","larded","condor","sinker","narced","quaver","atones","farted","elopes","winger","mottle","loaned","smears","joanne","boozes","waster","digger","swoops","smokey","nation","drivel","ceased","miffed","faiths","pisses","frames","fooled","milled","dither","crazed","darryl","mulder","posses","sumter","weasel","pedals","brawny","charge","welted","spanks","sallow","joined","shaker","blocks","mattie","swirls","driver","belles","chomps","blower","roared","ratted","hailed","taunts","steamy","parrot","deafer","chewed","spaces","cuffed","molded","winked","runnel","hollow","fluted","bedded","crepes","stakes","vested","parley","burton","loiter","massey","carnap","closed","bailed","milder","heists","morale","putter","snyder","damion","conned","little","pooped","ticced","cocked","halves","wishes","francs","goblet","carlin","pecked","julius","raster","shocks","dawned","loosen","swears","buried","peters","treats","noshed","hedges","trumps","rabies","ronnie","forces","ticked","bodies","proved","dadoes","halved","warner","divest","thumbs","fettle","ponies","testis","ranked","clouts","slates","tauted","stools","dodged","chancy","trawls","things","sorrow","levies","glides","battle","sauced","doomed","seller","strove","ballet","bumper","gooses","foiled","plowed","glints","chanel","petals","darted","seared","trunks","hatter","yokels","vanned","tweedy","rubles","crones","nettie","roofed","dusted","dicker","fakers","rusted","bedder","darrin","bigger","baylor","crocks","niches","tented","cashed","splats","quoted","soloed","tessie","stiles","bearer","hissed","soiled","adored","bowery","snakes","wagers","rafter","crests","plaids","cordon","listed","lawson","scared","brazos","horded","greens","marred","mushes","hooper","halter","ration","calked","erodes","plumed","mummer","pinged","curios","slated","ranter","pillow","frills","whaled","bathos","madden","totted","reamed","bellow","golfer","seaman","barred","merger","hipped","silken","hastes","strays","slinks","hooted","convex","singed","leased","bummed","leaner","molted","naught","caters","tidied","forges","sealer","gulled","plumps","racket","fitted","rafted","drapes","nasser","tamara","winced","juliet","ledger","bettie","howell","reeved","spiced","thebes","apices","dorsey","welled","feeler","warded","reader","folded","lepers","cranky","bosses","ledges","player","yellow","lunged","mattes","confer","malign","shared","brandy","filmed","rhinos","pulsed","rouses","stones","mixers","cooped","joiner","papped","liston","capote","salvos","wicker","ciders","hoofed","wefted","locket","picker","nougat","limpid","hooter","jailer","peaces","mashes","custer","wallis","purees","trends","irater","honied","wavers","tanner","change","hinges","tatted","cookie","catnap","carton","crimed","betted","veined","surges","rumped","merlin","convey","placid","harped","dianna","hookey","nobles","carted","elided","whined","glover","bleats","stales","husker","hearer","tartan","weaker","skewer","lumbar","temper","gigged","gawked","mayors","pigged","gather","valves","mitten","largos","boreas","judges","cozens","censor","frilly","dumbed","downer","jogger","scolds","danced","floras","funded","lumped","dashes","azores","quites","chunks","washed","duller","bilges","cruels","brooks","fishes","smoked","leaped","hotter","trials","heaves","rouges","kissed","sleety","manses","spites","starts","banded","clings","titted","vetoed","mister","mildew","wailed","sheets","peeked","passer","felted","broken","lieges","ruffed","bracts","buster","muffed","lanker","breaks","coffey","sighed","charms","balded","kisser","booths","leaven","cheeps","billed","lauder","bumped","career","stocks","airier","limped","jeanie","roamed","carves","lilted","router","bonnie","denver","briggs","steeps","nerves","oinked","bucked","hooves","dancer","burris","parked","swells","collie","perked","cooler","fopped","wedder","malted","sabers","lidded","conner","rogues","fought","dapper","purled","crowds","barnes","bonner","globed","goners","yankee","probes","trains","sayers","jersey","valley","vatted","tauter","dulled","mucked","jotted","border","genres","banked","filter","hitler","dipper","dollie","sieves","joliet","tilted","checks","sports","soughs","ported","causes","gelded","mooter","grills","parred","tipped","placer","slayer","glided","basked","rinses","tamper","bunged","nabbed","climbs","faeces","hanson","brainy","wicket","crowns","calmed","tarred","spires","deanne","gravel","messes","snides","tugged","denier","moslem","erased","mutter","blahed","hunker","fasten","garbed","cracks","braked","rasped","ravens","mutton","tester","tories","pinker","titled","arisen","softer","woolen","disses","likest","dicier","nagged","lipton","plumbs","manged","faulty","sacred","whiter","erases","padres","haired","captor","metals","cardin","yowled","trusts","revels","boxers","toured","spouts","sodded","judged","holley","figged","pricey","lapses","harper","beaned","sewers","caused","willie","farmer","pissed","bevies","bolled","bugler","votive","person","linton","senses","supped","mashed","pincer","wetter","tangos","sticky","lodger","loader","daunts","peaked","moused","sleeps","lasted","tasked","awards","lovely","gushed","spurts","canter","mantis","coaled","groans","dannie","oopses","sneaky","vogues","mobile","plumes","chides","theses","marcia","parser","flexed","stayed","fouler","tusked","quartz","daubed","clancy","rouged","flaked","norton","dunner","corded","shelly","hester","fucker","polled","rodger","yeager","zinced","livens","browne","gonged","pubbed","sapped","thrive","placed","jensen","moises","scopes","stumpy","stocky","heller","levers","morals","wheres","gasped","jobber","leaved","champs","rosier","pallet","shooed","parses","bender","closet","pureed","routes","verges","bulled","foster","rummer","molten","condos","better","cotter","lassos","grafts","vendor","thrace","codded","tinker","bullet","beaker","garden","spiels","popper","skills","plated","farrow","flexes","esters","brains","handel","puller","dickey","creeks","ballot","singer","sicker","spayed","spoils","rubier","missed","framed","bonnet","molder","mugger","waived","taster","robles","tracks","nearer","lister","horsed","drakes","lopped","lubber","busied","button","eluded","ceases","sought","realer","lasers","pollen","crisps","binned","darrel","crafty","gleams","lonely","gordon","harley","damian","whiles","wilton","lesser","mallow","kenyon","wimped","scened","risked","hunter","rooter","ramses","inches","goaded","ferber","freaky","nerved","spoken","lovers","letter","marrow","bulbed","braver","sloped","breads","cannes","bassos","orated","clever","darren","bredes","gouger","servos","trites","troths","flunky","jammed","bugged","watter","motive","humped","writer","pestle","rilled","packer","foists","croats","floury","napier","floors","scotty","sevens","harrow","welter","quacks","daybed","lorded","pulses","pokier","fatten","midges","joints","snoopy","looter","monies","canted","riffed","misses","bunker","piston","yessed","earner","hawked","wedged","brewer","nested","graver","hoaxes","slaves","pricks","magpie","bernie","rapier","roster","poohed","corner","trysts","rogers","whirls","bathed","teasel","opener","minced","sister","dreamy","worker","rinked","panted","triton","mervin","snowed","leafed","thinks","lesson","millet","larson","lagged","likely","stormy","fortes","hordes","wovens","kinked","mettle","seated","shirts","solver","giants","jilted","leaded","mendez","lowers","bidder","greats","pepped","flours","versus","canton","weller","cowper","tapped","dueled","mussed","rubies","bonged","steals","formed","smalls","sculls","docket","ouster","gunned","thumps","curred","withes","putted","buttes","bloats","parsed","galley","preses","tagged","hanger","planes","chords","shafts","carson","posits","zinger","solves","tensed","tastes","rinsed","kenned","bitten","leslie","chanty","candor","daises","baggie","wedded","paints","moored","haloed","hornet","lifted","fender","guiles","swifts","flicks","lancer","spares","pellet","passed","finked","joanna","bidden","swamps","lapped","leered","served","shirrs","choker","limper","marker","nudged","triter","thanks","peered","bruins","loaves","fabled","lathes","pipers","hooped","orates","burned","swines","sprats","warder","colder","crazes","reined","prized","majors","darrow","waifed","rooked","rickey","patter","shrive","gropes","gassed","throve","region","weaken","hettie","walton","galled","convoy","wesson","exudes","tinted","clanks","blinks","slacks","stilts","franny","socket","wished","kidded","knotty","turves","cashes","geared","sunned","glowed","sadden","harlem","testes","sweets","becket","blazes","batter","fellow","clovis","copier","shaped","husked","gimlet","rooney","taints","sashes","bossed","cootie","franck","probed","bagged","smocks","batten","spared","chills","relics","meyers","grader","tromps","dimmer","pasted","pepper","capped","played","junket","easier","palmed","pander","vaguer","bulged","dissed","borges","raises","wallow","jigged","bogged","burped","neater","rammed","fibers","castor","skirts","cancer","tilled","spored","dander","denims","budges","trucks","sowers","yapped","cadges","wrists","hacker","graved","vipers","noshes","minted","lessor","cassia","wrecks","hidden","brando","honeys","chilli","ragged","breded","punier","stacey","sisses","jocked","croaks","dinned","walker","heston","flares","coined","cannot","chocks","leases","wander","balder","warmer","bawled","donnie","damson","header","chilly","models","simper","watery","milked","poises","combed","toilet","gallop","sonnet","loosed","yawned","splays","pauses","bother","graphs","shrews","scones","manuel","milers","hotels","bennie","flores","spells","grimed","tenses","staged","puffer","posies","motion","fudged","fainer","tatter","seraph","nansen","months","muppet","tamera","shaman","falser","becker","lisbon","clefts","weeper","mendel","girder","takers","torsos","forked","dances","stated","yelled","scants","frothy","rolled","yodels","listen","craned","brooms","suffer","easter","shills","craves","bleeps","belled","dished","bordon","zither","jacket","lammer","kirked","shaved","atoned","frumpy","nosier","vender","graced","clingy","chants","wrests","cursed","prunes","tarter","stripe","coffee","veiled","tweeds","shrine","spines","kegged","melvin","gasser","market","marten","peeped","sanger","somber","spider","netted","radium","slings","scarfs","mended","creels","shaves","payers","bunked","movers","beings","conked","cozies","benton","codger","prints","gusset","longed","burner","jambed","mullet","fogged","scores","carbon","sleeks","helped","waxier","gilded","harlot","winces","tenser","lowell","ramsey","kennan","booted","beaver","rested","shouts","hickey","looped","swings","wonted","dilled","defers","lolled","pupped","cruets","solved","romper","defter","chokes","kithed","garnet","bookie","stared","stares","latter","lazies","fanned","wagged","dunces","corked","cloned","prided","baxter","pusses","boomed","masses","warren","weaves","delves","handed","merton","lusher","hepper","gibber","sender","parsec","snares","masher","seamed","sweats","welles","gagged","curter","mother","beeped","vealed","shoved","slaver","hacked","gutted","ranged","bashed","closer","storks","meshed","cortex","copper","severn","gripes","carlos","scares","crates","boiled","ginned","mouses","raided","greyed","verier","slopes","fenced","sniper","priced","flawed","buffed","spacey","favors","platen","miller","walled","cutter","skated","holier","beamed","waiter","drowns","clomps","quarks","bested","frisks","purged","scalds","marian","flower","howled","plover","bikers","trails","hagged","smirks","sitter","carmen","lanced","plants","nobler","yakked","thesis","lassen","margin","wagner","sifter","houses","screws","booker","dormer","meters","padded","loaded","cartel","sutton","willis","chatty","dunked","dreamt","dalton","fables","coveys","muller","shanty","adders","tailor","helper","liters","butted","maiman","hollie","gallon","xavier","shrank","mickey","rather","powers","keened","doused","kisses","flanks","dotted","phased","dumped","linger","kramer","spaced","soften","strife","rowers","hovers","crimes","crooks","carrel","braces","lander","shrove","skulks","banker","itches","dropsy","misted","pulped","cloche","fawned","states","teared","beeper","raider","groves","livery","aerier","keenan","severe","sabres","bogies","coated","harlow","tanked","mellow","cozier","shanks","spooky","blamed","tricks","sleets","punted","jumped","caxton","warped","halley","frisky","shines","skater","lumber","truces","sliced","gibbet","narked","chives","graves","gummed","holler","glazes","nieves","hushed","nought","prated","chored","cloudy","kidder","huston","straws","twined","gifted","rodney","haloes","france","wirier","mercia","rubbed","coaxed","sumner","snipes","nipper","leiden","madman","margie","footed","firmed","budded","froths","senior","hoover","tailed","glider","straps","stalks","billow","racked","javier","zoomed","shades","whores","braids","roused","sudden","dogies","fencer","snaked","flings","traded","gunner","snider","staten","levees","lathed","sailor","waited","muster","clothe","lulled","cargos","revved","sooths","flamed","borers","feller","bladed","oliver","collin","wusses","murder","parted","jailed","frayed","doored","cheeks","misled","belted","winter","merges","shaven","fudges","tabbed","forget","sloths","cachet","mealed","sassed","salter","haunts","ranger","rivets","deeded","reaped","damped","crated","youths","whacks","tamers","misery","seeped","eerier","tiller","busses","gloved","hushes","cronus","pruned","casket","direst","guilds","motley","spools","fevers","snores","greece","elides","waists","rattle","trader","juster","rashes","stoney","pipped","solder","sinner","prides","rugged","steers","gnarly","titter","cities","walter","stolen","steaks","hawker","weaned","jobbed","jacked","pikers","hipper","spoilt","beeves","craved","gotten","balked","sherry","looney","crisis","callie","swiped","fished","rooted","bopped","bowler","escher","chumps","jerrod","lefter","snooty","fillet","scales","comets","lisped","decked","clowns","horned","robber","bottle","reeled","crapes","banter","martel","dowels","brandt","sweeps","heeled","tabled","manors","danger","dionne","prayer","decker","millie","boated","damned","horses","globes","failed","lammed","nigher","joyner","sobers","chided","tipper","parcel","flakes","fugger","elated","hinder","hopper","crafts","wipers","badder","jessie","matted","wafted","pealed","cheats","elites","torres","bushed","sneaks","tidies","brings","stalls","payees","zonked","danker","poshes","smelts","stoops","warden","chicks","ramsay","budged","firmer","glazed","heated","slices","hovels","belied","shifts","pauper","tinges","weston","casted","titles","droves","roomer","modals","seamen","wearer","blonde","berlin","libbed","tensor","hokier","lambed","graped","headed","copped","eroses","fagged","filler","keener","stages","civets","spills","tithed","sullen","sucked","briton","whaler","hooded","tittle","bucket","furled","darned","planet","clucks","batted","dagger","brides","severs","pathos","grainy","relied","carpel","makers","lancet","slowed","messed","ravels","faster","gabbed","chance","grayed","santos","spends","chinos","saints","swirly","dories","wilson","milton","clangs","manual","nodded","signer","stript","etched","vaster","wastes","stored","minces","purred","marvin","pinned","skulls","heaved","wadded","fowled","hashed","mullen","relief","hatted","primed","chaffs","canned","lackey","showed","shandy","chases","maggie","deafen","bussed","differ","worked","marted","ducked","socked","fussed","greyer","herder","trusty","follow","samson","babies","whorls","stanks","manson","cranes","murrow","shrink","genius","holder","lenses","yucked","termed","ruined","junker","belies","joshed","cooled","basted","greeks","fuller","healer","carver","havens","drunks","sucker","lotion","glared","healed","pocked","rifles","weaved","canoed","punter","hinton","settle","boobed","hinted","scored","harder","status","sloven","hayden","golfed","scoots","bloods","slaked","jugged","louses","cassie","shaded","rushed","pitied","barked","honked","rasher","forced","shaver","vowels","holden","pelvis","blades","chests","preyer","floods","deanna","cation","mapper","falter","dabbed","mocker","nestle","shucks","heeded","ticker","binges","summer","slumps","lusted","scampi","crofts","gorges","pardon","torses","smokes","lashed","bailey","jabbed","calmer","preset","forbes","hasted","wormed","winged","minors","banner","grazed","hewers","kernel","jolted","sniped","clunky","ratios","blinds","ganges","misers","spikes","riders","hallow","grumpy","barren","summed","infers","places","jarred","killer","plaint","goofed","subbed","prudes","sipped","kookie","whines","droopy","palled","cherry","proves","mobbed","spaded","cheese","pluses","bathes","motels","spewed","soaked","howler","puffed","malled","shrike","slided","fulled","pouted","shames","lessen","ringed","teemed","grands","linked","wooten","feuded","deaden","scents","flutes","salton"};
			*/

		String beginWord = "nanny";
		String endWord = "aloud";
		String[] words = { "ricky", "grind", "cubic", "panic", "lover", "farce", "gofer", "sales",
				"flint", "omens", "lipid", "briny", "cloth", "anted", "slime", "oaten", "harsh",
				"touts", "stoop", "cabal", "lazed", "elton", "skunk", "nicer", "pesky", "kusch",
				"bused", "kinda", "tunis", "enjoy", "aches", "prowl", "babar", "rooms", "burst",
				"slush", "pines", "urine", "pinky", "bayed", "mania", "light", "flare", "wares",
				"women", "verne", "moron", "shine", "bluer", "zeros", "bleak", "brief", "tamra",
				"vasts", "jamie", "lairs", "penal", "worst", "yowls", "pills", "taros", "addle",
				"alyce", "creep", "saber", "floyd", "cures", "soggy", "vexed", "vilma", "cabby",
				"verde", "euler", "cling", "wanna", "jenny", "donor", "stole", "sakha", "blake",
				"sanes", "riffs", "forge", "horus", "sered", "piked", "prosy", "wases", "glove",
				"onset", "spake", "benin", "talks", "sites", "biers", "wendy", "dante", "allan",
				"haven", "nears", "shaka", "sloth", "perky", "spear", "spend", "clint", "dears",
				"sadly", "units", "vista", "hinds", "marat", "natal", "least", "bough", "pales",
				"boole", "ditch", "greys", "slunk", "bitch", "belts", "sense", "skits", "monty",
				"yawns", "music", "hails", "alien", "gibes", "lille", "spacy", "argot", "wasps",
				"drubs", "poops", "bella", "clone", "beast", "emend", "iring", "start", "darla",
				"bells", "cults", "dhaka", "sniff", "seers", "bantu", "pages", "fever", "tacky",
				"hoses", "strop", "climb", "pairs", "later", "grant", "raven", "stael", "drips",
				"lucid", "awing", "dines", "balms", "della", "galen", "toned", "snips", "shady",
				"chili", "fears", "nurse", "joint", "plump", "micky", "lions", "jamal", "queer",
				"ruins", "frats", "spoof", "semen", "pulps", "oldie", "coors", "rhone", "papal",
				"seals", "spans", "scaly", "sieve", "klaus", "drums", "tided", "needs", "rider",
				"lures", "treks", "hares", "liner", "hokey", "boots", "primp", "laval", "limes",
				"putts", "fonda", "damon", "pikes", "hobbs", "specs", "greet", "ketch", "braid",
				"purer", "tsars", "berne", "tarts", "clean", "grate", "trips", "chefs", "timex",
				"vicky", "pares", "price", "every", "beret", "vices", "jodie", "fanny", "mails",
				"built", "bossy", "farms", "pubic", "gongs", "magma", "quads", "shell", "jocks",
				"woods", "waded", "parka", "jells", "worse", "diner", "risks", "bliss", "bryan",
				"terse", "crier", "incur", "murky", "gamed", "edges", "keens", "bread", "raced",
				"vetch", "glint", "zions", "porno", "sizes", "mends", "ached", "allie", "bands",
				"plank", "forth", "fuels", "rhyme", "wimpy", "peels", "foggy", "wings", "frill",
				"edgar", "slave", "lotus", "point", "hints", "germs", "clung", "limed", "loafs",
				"realm", "myron", "loopy", "plush", "volts", "bimbo", "smash", "windy", "sours",
				"choke", "karin", "boast", "whirr", "tiber", "dimes", "basel", "cutes", "pinto",
				"troll", "thumb", "decor", "craft", "tared", "split", "josue", "tramp", "screw",
				"label", "lenny", "apses", "slept", "sikhs", "child", "bouts", "cites", "swipe",
				"lurks", "seeds", "fists", "hoard", "steed", "reams", "spoil", "diego", "peale",
				"bevel", "flags", "mazes", "quart", "snipe", "latch", "lards", "acted", "falls",
				"busby", "holed", "mummy", "wrong", "wipes", "carlo", "leers", "wails", "night",
				"pasty", "eater", "flunk", "vedas", "curse", "tyros", "mirth", "jacky", "butte",
				"wired", "fixes", "tares", "vague", "roved", "stove", "swoon", "scour", "coked",
				"marge", "cants", "comic", "corns", "zilch", "typos", "lives", "truer", "comma",
				"gaily", "teals", "witty", "hyper", "croat", "sways", "tills", "hones", "dowel",
				"llano", "clefs", "fores", "cinch", "brock", "vichy", "bleed", "nuder", "hoyle",
				"slams", "macro", "arabs", "tauts", "eager", "croak", "scoop", "crime", "lurch",
				"weals", "fates", "clipt", "teens", "bulls", "domed", "ghana", "culls", "frame",
				"hanky", "jared", "swain", "truss", "drank", "lobby", "lumps", "pansy", "whews",
				"saris", "trite", "weeps", "dozes", "jeans", "flood", "chimu", "foxes", "gelds",
				"sects", "scoff", "poses", "mares", "famed", "peers", "hells", "laked", "zests",
				"wring", "steal", "snoot", "yodel", "scamp", "ellis", "bandy", "marry", "jives",
				"vises", "blurb", "relay", "patch", "haley", "cubit", "heine", "place", "touch",
				"grain", "gerry", "badly", "hooke", "fuchs", "savor", "apron", "judge", "loren",
				"britt", "smith", "tammy", "altar", "duels", "huber", "baton", "dived", "apace",
				"sedan", "basts", "clark", "mired", "perch", "hulks", "jolly", "welts", "quack",
				"spore", "alums", "shave", "singe", "lanny", "dread", "profs", "skeet", "flout",
				"darin", "newed", "steer", "taine", "salvo", "mites", "rules", "crash", "thorn",
				"olive", "saves", "yawed", "pique", "salon", "ovens", "dusty", "janie", "elise",
				"carve", "winds", "abash", "cheep", "strap", "fared", "discs", "poxed", "hoots",
				"catch", "combo", "maize", "repay", "mario", "snuff", "delve", "cored", "bards",
				"sudan", "shuns", "yukon", "jowls", "wayne", "torus", "gales", "creek", "prove",
				"needy", "wisps", "terri", "ranks", "books", "dicky", "tapes", "aping", "padre",
				"roads", "nines", "seats", "flats", "rains", "moira", "basic", "loves", "pulls",
				"tough", "gills", "codes", "chest", "teeny", "jolts", "woody", "flame", "asked",
				"dulls", "hotly", "glare", "mucky", "spite", "flake", "vines", "lindy", "butts",
				"froth", "beeps", "sills", "bunny", "flied", "shaun", "mawed", "velds", "voled",
				"doily", "patel", "snake", "thigh", "adler", "calks", "desks", "janus", "spunk",
				"baled", "match", "strip", "hosed", "nippy", "wrest", "whams", "calfs", "sleet",
				"wives", "boars", "chain", "table", "duked", "riped", "edens", "galas", "huffs",
				"biddy", "claps", "aleut", "yucks", "bangs", "quids", "glenn", "evert", "drunk",
				"lusts", "senna", "slate", "manet", "roted", "sleep", "loxes", "fluky", "fence",
				"clamp", "doted", "broad", "sager", "spark", "belch", "mandy", "deana", "beyer",
				"hoist", "leafy", "levee", "libel", "tonic", "aloes", "steam", "skews", "tides",
				"stall", "rifts", "saxon", "mavis", "asama", "might", "dotes", "tangs", "wroth",
				"kited", "salad", "liens", "clink", "glows", "balky", "taffy", "sided", "sworn",
				"oasis", "tenth", "blurt", "tower", "often", "walsh", "sonny", "andes", "slump",
				"scans", "boded", "chive", "finer", "ponce", "prune", "sloes", "dined", "chums",
				"dingo", "harte", "ahead", "event", "freer", "heart", "fetch", "sated", "soapy",
				"skins", "royal", "cuter", "loire", "minot", "aisle", "horny", "slued", "panel",
				"eight", "snoop", "pries", "clive", "pored", "wrist", "piped", "daren", "cells",
				"parks", "slugs", "cubed", "highs", "booze", "weary", "stain", "hoped", "finny",
				"weeds", "fetid", "racer", "tasks", "right", "saint", "shahs", "basis", "refer",
				"chart", "seize", "lulls", "slant", "belay", "clots", "jinny", "tours", "modes",
				"gloat", "dunks", "flute", "conch", "marts", "aglow", "gayer", "lazes", "dicks",
				"chime", "bears", "sharp", "hatch", "forms", "terry", "gouda", "thins", "janet",
				"tonya", "axons", "sewed", "danny", "rowdy", "dolts", "hurry", "opine", "fifty",
				"noisy", "spiky", "humid", "verna", "poles", "jayne", "pecos", "hooky", "haney",
				"shams", "snots", "sally", "ruder", "tempe", "plunk", "shaft", "scows", "essie",
				"dated", "fleet", "spate", "bunin", "hikes", "sodas", "filly", "thyme", "fiefs",
				"perks", "chary", "kiths", "lidia", "lefty", "wolff", "withe", "three", "crawl",
				"wotan", "brown", "japed", "tolls", "taken", "threw", "crave", "clash", "layer",
				"tends", "notes", "fudge", "musky", "bawdy", "aline", "matts", "shirr", "balks",
				"stash", "wicks", "crepe", "foods", "fares", "rotes", "party", "petty", "press",
				"dolly", "mangy", "leeks", "silly", "leant", "nooks", "chapt", "loose", "caged",
				"wages", "grist", "alert", "sheri", "moody", "tamps", "hefts", "souls", "rubes",
				"rolex", "skulk", "veeps", "nonce", "state", "level", "whirl", "bight", "grits",
				"reset", "faked", "spiny", "mixes", "hunks", "major", "missy", "arius", "damns",
				"fitly", "caped", "mucus", "trace", "surat", "lloyd", "furry", "colin", "texts",
				"livia", "reply", "twill", "ships", "peons", "shear", "norms", "jumbo", "bring",
				"masks", "zippy", "brine", "dorks", "roded", "sinks", "river", "wolfs", "strew",
				"myths", "pulpy", "prank", "veins", "flues", "minus", "phone", "banns", "spell",
				"burro", "brags", "boyle", "lambs", "sides", "knees", "clews", "aired", "skirt",
				"heavy", "dimer", "bombs", "scums", "hayes", "chaps", "snugs", "dusky", "loxed",
				"ellen", "while", "swank", "track", "minim", "wiled", "hazed", "roofs", "cantu",
				"sorry", "roach", "loser", "brass", "stint", "jerks", "dirks", "emory", "campy",
				"poise", "sexed", "gamer", "catty", "comte", "bilbo", "fasts", "ledge", "drier",
				"idles", "doors", "waged", "rizal", "pured", "weirs", "crisp", "tasty", "sored",
				"palmy", "parts", "ethel", "unify", "crows", "crest", "udder", "delis", "punks",
				"dowse", "totes", "emile", "coded", "shops", "poppa", "pours", "gushy", "tiffs",
				"shads", "birds", "coils", "areas", "boons", "hulls", "alter", "lobes", "pleat",
				"depth", "fires", "pones", "serra", "sweat", "kline", "malay", "ruled", "calve",
				"tired", "drabs", "tubed", "wryer", "slung", "union", "sonya", "aided", "hewed",
				"dicey", "grids", "nixed", "whits", "mills", "buffs", "yucky", "drops", "ready",
				"yuppy", "tweet", "napes", "cadre", "teach", "rasps", "dowdy", "hoary", "canto",
				"posed", "dumbo", "kooks", "reese", "snaky", "binge", "byron", "phony", "safer",
				"friar", "novel", "scale", "huron", "adorn", "carla", "fauna", "myers", "hobby",
				"purse", "flesh", "smock", "along", "boils", "pails", "times", "panza", "lodge",
				"clubs", "colby", "great", "thing", "peaks", "diana", "vance", "whets", "bergs",
				"sling", "spade", "soaks", "beach", "traps", "aspen", "romps", "boxed", "fakir",
				"weave", "nerds", "swazi", "dotty", "curls", "diver", "jonas", "waite", "verbs",
				"yeast", "lapel", "barth", "soars", "hooks", "taxed", "slews", "gouge", "slags",
				"chang", "chafe", "saved", "josie", "syncs", "fonds", "anion", "actor", "seems",
				"pyrex", "isiah", "glued", "groin", "goren", "waxes", "tonia", "whine", "scads",
				"knelt", "teaks", "satan", "tromp", "spats", "merry", "wordy", "stake", "gland",
				"canal", "donna", "lends", "filed", "sacks", "shied", "moors", "paths", "older",
				"pooch", "balsa", "riced", "facet", "decaf", "attic", "elder", "akron", "chomp",
				"chump", "picky", "money", "sheer", "bolls", "crabs", "dorms", "water", "veers",
				"tease", "dummy", "dumbs", "lethe", "halls", "rifer", "demon", "fucks", "whips",
				"plops", "fuses", "focal", "taces", "snout", "edict", "flush", "burps", "dawes",
				"lorry", "spews", "sprat", "click", "deann", "sited", "aunts", "quips", "godly",
				"pupil", "nanny", "funks", "shoon", "aimed", "stacy", "helms", "mints", "banks",
				"pinch", "local", "twine", "pacts", "deers", "halos", "slink", "preys", "potty",
				"ruffs", "pusan", "suits", "finks", "slash", "prods", "dense", "edsel", "heeds",
				"palls", "slats", "snits", "mower", "rares", "ailed", "rouge", "ellie", "gated",
				"lyons", "duded", "links", "oaths", "letha", "kicks", "firms", "gravy", "month",
				"kongo", "mused", "ducal", "toted", "vocal", "disks", "spied", "studs", "macao",
				"erick", "coupe", "starr", "reaps", "decoy", "rayon", "nicks", "breed", "cosby",
				"haunt", "typed", "plain", "trays", "muled", "saith", "drano", "cower", "snows",
				"buses", "jewry", "argus", "doers", "flays", "swish", "resin", "boobs", "sicks",
				"spies", "bails", "wowed", "mabel", "check", "vapid", "bacon", "wilda", "ollie",
				"loony", "irked", "fraud", "doles", "facts", "lists", "gazed", "furls", "sunks",
				"stows", "wilde", "brick", "bowed", "guise", "suing", "gates", "niter", "heros",
				"hyped", "clomp", "never", "lolls", "rangy", "paddy", "chant", "casts", "terns",
				"tunas", "poker", "scary", "maims", "saran", "devon", "tripe", "lingo", "paler",
				"coped", "bride", "voted", "dodge", "gross", "curds", "sames", "those", "tithe",
				"steep", "flaks", "close", "swops", "stare", "notch", "prays", "roles", "crush",
				"feuds", "nudge", "baned", "brake", "plans", "weepy", "dazed", "jenna", "weiss",
				"tomes", "stews", "whist", "gibed", "death", "clank", "cover", "peeks", "quick",
				"abler", "daddy", "calls", "scald", "lilia", "flask", "cheer", "grabs", "megan",
				"canes", "jules", "blots", "mossy", "begun", "freak", "caved", "hello", "hades",
				"theed", "wards", "darcy", "malta", "peter", "whorl", "break", "downs", "odder",
				"hoofs", "kiddo", "macho", "fords", "liked", "flees", "swing", "elect", "hoods",
				"pluck", "brook", "astir", "bland", "sward", "modal", "flown", "ahmad", "waled",
				"craps", "cools", "roods", "hided", "plath", "kings", "grips", "gives", "gnats",
				"tabby", "gauls", "think", "bully", "fogey", "sawed", "lints", "pushy", "banes",
				"drake", "trail", "moral", "daley", "balds", "chugs", "geeky", "darts", "soddy",
				"haves", "opens", "rends", "buggy", "moles", "freud", "gored", "shock", "angus",
				"puree", "raves", "johns", "armed", "packs", "minis", "reich", "slots", "totem",
				"clown", "popes", "brute", "hedge", "latin", "stoke", "blend", "pease", "rubik",
				"greer", "hindi", "betsy", "flows", "funky", "kelli", "humps", "chewy", "welds",
				"scowl", "yells", "cough", "sasha", "sheaf", "jokes", "coast", "words", "irate",
				"hales", "camry", "spits", "burma", "rhine", "bends", "spill", "stubs", "power",
				"voles", "learn", "knoll", "style", "twila", "drove", "dacca", "sheen", "papas",
				"shale", "jones", "duped", "tunny", "mouse", "floss", "corks", "skims", "swaps",
				"inned", "boxer", "synch", "skies", "strep", "bucks", "belau", "lower", "flaky",
				"quill", "aural", "rufus", "floes", "pokes", "sends", "sates", "dally", "boyer",
				"hurts", "foyer", "gowns", "torch", "luria", "fangs", "moats", "heinz", "bolts",
				"filet", "firth", "begot", "argue", "youth", "chimp", "frogs", "kraft", "smite",
				"loges", "loons", "spine", "domes", "pokey", "timur", "noddy", "doggy", "wades",
				"lanes", "hence", "louts", "turks", "lurid", "goths", "moist", "bated", "giles",
				"stood", "winos", "shins", "potts", "brant", "vised", "alice", "rosie", "dents",
				"babes", "softy", "decay", "meats", "tanya", "rusks", "pasts", "karat", "nuked",
				"gorge", "kinks", "skull", "noyce", "aimee", "watch", "cleat", "stuck", "china",
				"testy", "doses", "safes", "stage", "bayes", "twins", "limps", "denis", "chars",
				"flaps", "paces", "abase", "grays", "deans", "maria", "asset", "smuts", "serbs",
				"whigs", "vases", "robyn", "girls", "pents", "alike", "nodal", "molly", "swigs",
				"swill", "slums", "rajah", "bleep", "beget", "thanh", "finns", "clock", "wafts",
				"wafer", "spicy", "sorer", "reach", "beats", "baker", "crown", "drugs", "daisy",
				"mocks", "scots", "fests", "newer", "agate", "drift", "marta", "chino", "flirt",
				"homed", "bribe", "scram", "bulks", "servo", "vesta", "divas", "preps", "naval",
				"tally", "shove", "ragas", "blown", "droll", "tryst", "lucky", "leech", "lines",
				"sires", "pyxed", "taper", "trump", "payee", "midge", "paris", "bored", "loads",
				"shuts", "lived", "swath", "snare", "boned", "scars", "aeons", "grime", "writs",
				"paige", "rungs", "blent", "signs", "davis", "dials", "daubs", "rainy", "fawns",
				"wrier", "golds", "wrath", "ducks", "allow", "hosea", "spike", "meals", "haber",
				"muses", "timed", "broom", "burks", "louis", "gangs", "pools", "vales", "altai",
				"elope", "plied", "slain", "chasm", "entry", "slide", "bawls", "title", "sings",
				"grief", "viola", "doyle", "peach", "davit", "bench", "devil", "latex", "miles",
				"pasha", "tokes", "coves", "wheel", "tried", "verdi", "wanda", "sivan", "prior",
				"fryer", "plots", "kicky", "porch", "shill", "coats", "borne", "brink", "pawed",
				"erwin", "tense", "stirs", "wends", "waxen", "carts", "smear", "rival", "scare",
				"phase", "bragg", "crane", "hocks", "conan", "bests", "dares", "molls", "roots",
				"dunes", "slips", "waked", "fours", "bolds", "slosh", "yemen", "poole", "solid",
				"ports", "fades", "legal", "cedes", "green", "curie", "seedy", "riper", "poled",
				"glade", "hosts", "tools", "razes", "tarry", "muddy", "shims", "sword", "thine",
				"lasts", "bloat", "soled", "tardy", "foots", "skiff", "volta", "murks", "croci",
				"gooks", "gamey", "pyxes", "poems", "kayla", "larva", "slaps", "abuse", "pings",
				"plows", "geese", "minks", "derby", "super", "inked", "manic", "leaks", "flops",
				"lajos", "fuzes", "swabs", "twigs", "gummy", "pyres", "shrew", "islet", "doled",
				"wooly", "lefts", "hunts", "toast", "faith", "macaw", "sonia", "leafs", "colas",
				"conks", "altos", "wiped", "scene", "boors", "patsy", "meany", "chung", "wakes",
				"clear", "ropes", "tahoe", "zones", "crate", "tombs", "nouns", "garth", "puked",
				"chats", "hanks", "baked", "binds", "fully", "soaps", "newel", "yarns", "puers",
				"carps", "spelt", "lully", "towed", "scabs", "prime", "blest", "patty", "silky",
				"abner", "temps", "lakes", "tests", "alias", "mines", "chips", "funds", "caret",
				"splat", "perry", "turds", "junks", "cramp", "saned", "peary", "snarl", "fired",
				"stung", "nancy", "bulge", "styli", "seams", "hived", "feast", "triad", "jaded",
				"elvin", "canny", "birth", "routs", "rimed", "pusey", "laces", "taste", "basie",
				"malls", "shout", "prier", "prone", "finis", "claus", "loops", "heron", "frump",
				"spare", "menus", "ariel", "crams", "bloom", "foxed", "moons", "mince", "mixed",
				"piers", "deres", "tempt", "dryer", "atone", "heats", "dario", "hawed", "swims",
				"sheet", "tasha", "dings", "clare", "aging", "daffy", "wried", "foals", "lunar",
				"havel", "irony", "ronny", "naves", "selma", "gurus", "crust", "percy", "murat",
				"mauro", "cowed", "clang", "biker", "harms", "barry", "thump", "crude", "ulnae",
				"thong", "pager", "oases", "mered", "locke", "merle", "soave", "petal", "poser",
				"store", "winch", "wedge", "inlet", "nerdy", "utter", "filth", "spray", "drape",
				"pukes", "ewers", "kinds", "dates", "meier", "tammi", "spoor", "curly", "chill",
				"loped", "gooey", "boles", "genet", "boost", "beets", "heath", "feeds", "growl",
				"livid", "midst", "rinds", "fresh", "waxed", "yearn", "keeps", "rimes", "naked",
				"flick", "plies", "deeps", "dirty", "hefty", "messy", "hairy", "walks", "leper",
				"sykes", "nerve", "rover", "jived", "brisk", "lenin", "viper", "chuck", "sinus",
				"luger", "ricks", "hying", "rusty", "kathy", "herds", "wider", "getty", "roman",
				"sandy", "pends", "fezes", "trios", "bites", "pants", "bless", "diced", "earth",
				"shack", "hinge", "melds", "jonah", "chose", "liver", "salts", "ratty", "ashed",
				"wacky", "yokes", "wanly", "bruce", "vowel", "black", "grail", "lungs", "arise",
				"gluts", "gluey", "navel", "coyer", "ramps", "miter", "aldan", "booth", "musty",
				"rills", "darns", "tined", "straw", "kerri", "hared", "lucks", "metes", "penny",
				"radon", "palms", "deeds", "earls", "shard", "pried", "tampa", "blank", "gybes",
				"vicki", "drool", "groom", "curer", "cubes", "riggs", "lanky", "tuber", "caves",
				"acing", "golly", "hodge", "beard", "ginny", "jibed", "fumes", "astor", "quito",
				"cargo", "randi", "gawky", "zings", "blind", "dhoti", "sneak", "fatah", "fixer",
				"lapps", "cline", "grimm", "fakes", "maine", "erika", "dealt", "mitch", "olden",
				"joist", "gents", "likes", "shelf", "silts", "goats", "leads", "marin", "spire",
				"louie", "evans", "amuse", "belly", "nails", "snead", "model", "whats", "shari",
				"quote", "tacks", "nutty", "lames", "caste", "hexes", "cooks", "miner", "shawn",
				"anise", "drama", "trike", "prate", "ayers", "loans", "botch", "vests", "cilia",
				"ridge", "thugs", "outed", "jails", "moped", "plead", "tunes", "nosed", "wills",
				"lager", "lacks", "cried", "wince", "berle", "flaws", "boise", "tibet", "bided",
				"shred", "cocky", "brice", "delta", "congo", "holly", "hicks", "wraps", "cocks",
				"aisha", "heard", "cured", "sades", "horsy", "umped", "trice", "dorky", "curve",
				"ferry", "haler", "ninth", "pasta", "jason", "honer", "kevin", "males", "fowls",
				"awake", "pores", "meter", "skate", "drink", "pussy", "soups", "bases", "noyes",
				"torts", "bogus", "still", "soupy", "dance", "worry", "eldon", "stern", "menes",
				"dolls", "dumpy", "gaunt", "grove", "coops", "mules", "berry", "sower", "roams",
				"brawl", "greed", "stags", "blurs", "swift", "treed", "taney", "shame", "easel",
				"moves", "leger", "ville", "order", "spock", "nifty", "brian", "elias", "idler",
				"serve", "ashen", "bizet", "gilts", "spook", "eaten", "pumas", "cotes", "broke",
				"toxin", "groan", "laths", "joins", "spots", "hated", "tokay", "elite", "rawer",
				"fiats", "cards", "sassy", "milks", "roost", "glean", "lutes", "chins", "drown",
				"marks", "pined", "grace", "fifth", "lodes", "rusts", "terms", "maxes", "savvy",
				"choir", "savoy", "spoon", "halve", "chord", "hulas", "sarah", "celia", "deems",
				"ninny", "wines", "boggy", "birch", "raved", "wales", "beams", "vibes", "riots",
				"warty", "nigel", "askew", "faxes", "sedge", "sheol", "pucks", "cynic", "relax",
				"boers", "whims", "bents", "candy", "luann", "slogs", "bonny", "barns", "iambs",
				"fused", "duffy", "guilt", "bruin", "pawls", "penis", "poppy", "owing", "tribe",
				"tuner", "moray", "timid", "ceded", "geeks", "kites", "curio", "puffy", "perot",
				"caddy", "peeve", "cause", "dills", "gavel", "manse", "joker", "lynch", "crank",
				"golda", "waits", "wises", "hasty", "paves", "grown", "reedy", "crypt", "tonne",
				"jerky", "axing", "swept", "posse", "rings", "staff", "tansy", "pared", "glaze",
				"grebe", "gonna", "shark", "jumps", "vials", "unset", "hires", "tying", "lured",
				"motes", "linen", "locks", "mamas", "nasty", "mamie", "clout", "nader", "velma",
				"abate", "tight", "dales", "serer", "rives", "bales", "loamy", "warps", "plato",
				"hooch", "togae", "damps", "ofter", "plumb", "fifes", "filmy", "wiper", "chess",
				"lousy", "sails", "brahe", "ounce", "flits", "hindu", "manly", "beaux", "mimed",
				"liken", "forts", "jambs", "peeps", "lelia", "brews", "handy", "lusty", "brads",
				"marne", "pesos", "earle", "arson", "scout", "showy", "chile", "sumps", "hiked",
				"crook", "herbs", "silks", "alamo", "mores", "dunce", "blaze", "stank", "haste",
				"howls", "trots", "creon", "lisle", "pause", "hates", "mulch", "mined", "moder",
				"devin", "types", "cindy", "beech", "tuned", "mowed", "pitts", "chaos", "colds",
				"bidet", "tines", "sighs", "slimy", "brain", "belle", "leery", "morse", "ruben",
				"prows", "frown", "disco", "regal", "oaken", "sheds", "hives", "corny", "baser",
				"fated", "throe", "revel", "bores", "waved", "shits", "elvia", "ferns", "maids",
				"color", "coifs", "cohan", "draft", "hmong", "alton", "stine", "cluck", "nodes",
				"emily", "brave", "blair", "blued", "dress", "bunts", "holst", "clogs", "rally",
				"knack", "demos", "brady", "blues", "flash", "goofy", "blocs", "diane", "colic",
				"smile", "yules", "foamy", "splay", "bilge", "faker", "foils", "condo", "knell",
				"crack", "gallo", "purls", "auras", "cakes", "doves", "joust", "aides", "lades",
				"muggy", "tanks", "middy", "tarps", "slack", "capet", "frays", "donny", "venal",
				"yeats", "misty", "denim", "glass", "nudes", "seeps", "gibbs", "blows", "bobbi",
				"shane", "yards", "pimps", "clued", "quiet", "witch", "boxes", "prawn", "kerry",
				"torah", "kinko", "dingy", "emote", "honor", "jelly", "grins", "trope", "vined",
				"bagel", "arden", "rapid", "paged", "loved", "agape", "mural", "budge", "ticks",
				"suers", "wendi", "slice", "salve", "robin", "bleat", "batik", "myles", "teddy",
				"flatt", "puppy", "gelid", "largo", "attar", "polls", "glide", "serum", "fundy",
				"sucks", "shalt", "sewer", "wreak", "dames", "fonts", "toxic", "hines", "wormy",
				"grass", "louse", "bowls", "crass", "benny", "moire", "margo", "golfs", "smart",
				"roxie", "wight", "reign", "dairy", "clops", "paled", "oddly", "sappy", "flair",
				"shown", "bulgy", "benet", "larch", "curry", "gulfs", "fends", "lunch", "dukes",
				"doris", "spoke", "coins", "manna", "conga", "jinns", "eases", "dunno", "tisha",
				"swore", "rhino", "calms", "irvin", "clans", "gully", "liege", "mains", "besot",
				"serge", "being", "welch", "wombs", "draco", "lynda", "forty", "mumps", "bloch",
				"ogden", "knits", "fussy", "alder", "danes", "loyal", "valet", "wooer", "quire",
				"liefs", "shana", "toyed", "forks", "gages", "slims", "cloys", "yates", "rails",
				"sheep", "nacho", "divan", "honks", "stone", "snack", "added", "basal", "hasps",
				"focus", "alone", "laxes", "arose", "lamed", "wrapt", "frail", "clams", "plait",
				"hover", "tacos", "mooch", "fault", "teeth", "marva", "mucks", "tread", "waves",
				"purim", "boron", "horde", "smack", "bongo", "monte", "swirl", "deals", "mikes",
				"scold", "muter", "sties", "lawns", "fluke", "jilts", "meuse", "fives", "sulky",
				"molds", "snore", "timmy", "ditty", "gasps", "kills", "carey", "jawed", "byers",
				"tommy", "homer", "hexed", "dumas", "given", "mewls", "smelt", "weird", "speck",
				"merck", "keats", "draws", "trent", "agave", "wells", "chews", "blabs", "roves",
				"grieg", "evens", "alive", "mulls", "cared", "garbo", "fined", "happy", "trued",
				"rodes", "thurs", "cadet", "alvin", "busch", "moths", "guild", "staci", "lever",
				"widen", "props", "hussy", "lamer", "riley", "bauer", "chirp", "rants", "poxes",
				"shyer", "pelts", "funny", "slits", "tinge", "ramos", "shift", "caper", "credo",
				"renal", "veils", "covey", "elmer", "mated", "tykes", "wooed", "briar", "gears",
				"foley", "shoes", "decry", "hypes", "dells", "wilds", "runts", "wilts", "white",
				"easts", "comer", "sammy", "lochs", "favor", "lance", "dawns", "bushy", "muted",
				"elsie", "creel", "pocks", "tenet", "cagey", "rides", "socks", "ogled", "soils",
				"sofas", "janna", "exile", "barks", "frank", "takes", "zooms", "hakes", "sagan",
				"scull", "heaps", "augur", "pouch", "blare", "bulbs", "wryly", "homey", "tubas",
				"limbo", "hardy", "hoagy", "minds", "bared", "gabby", "bilks", "float", "limns",
				"clasp", "laura", "range", "brush", "tummy", "kilts", "cooed", "worms", "leary",
				"feats", "robes", "suite", "veals", "bosch", "moans", "dozen", "rarer", "slyer",
				"cabin", "craze", "sweet", "talon", "treat", "yanks", "react", "creed", "eliza",
				"sluts", "cruet", "hafts", "noise", "seder", "flies", "weeks", "venus", "backs",
				"eider", "uriel", "vouch", "robed", "hacks", "perth", "shiny", "stilt", "torte",
				"throb", "merer", "twits", "reeds", "shawl", "clara", "slurs", "mixer", "newts",
				"fried", "woolf", "swoop", "kaaba", "oozed", "mayer", "caned", "laius", "lunge",
				"chits", "kenny", "lifts", "mafia", "sowed", "piled", "stein", "whack", "colts",
				"warms", "cleft", "girds", "seeks", "poets", "angel", "trade", "parsi", "tiers",
				"rojas", "vexes", "bryce", "moots", "grunt", "drain", "lumpy", "stabs", "poohs",
				"leapt", "polly", "cuffs", "giddy", "towns", "dacha", "quoth", "provo", "dilly",
				"carly", "mewed", "tzars", "crock", "toked", "speak", "mayas", "pssts", "ocher",
				"motel", "vogue", "camps", "tharp", "taunt", "drone", "taint", "badge", "scott",
				"scats", "bakes", "antes", "gruel", "snort", "capes", "plate", "folly", "adobe",
				"yours", "papaw", "hench", "moods", "clunk", "chevy", "tomas", "narcs", "vonda",
				"wiles", "prigs", "chock", "laser", "viced", "stiff", "rouse", "helps", "knead",
				"gazer", "blade", "tumid", "avail", "anger", "egged", "guide", "goads", "rabin",
				"toddy", "gulps", "flank", "brats", "pedal", "junky", "marco", "tinny", "tires",
				"flier", "satin", "darth", "paley", "gumbo", "rared", "muffs", "rower", "prude",
				"frees", "quays", "homes", "munch", "beefs", "leash", "aston", "colon", "finch",
				"bogey", "leaps", "tempo", "posts", "lined", "gapes", "locus", "maori", "nixes",
				"liven", "songs", "opted", "babel", "wader", "barer", "farts", "lisps", "koran",
				"lathe", "trill", "smirk", "mamma", "viler", "scurf", "ravel", "brigs", "cooky",
				"sachs", "fulls", "goals", "turfs", "norse", "hauls", "cores", "fairy", "pluto",
				"kneed", "cheek", "pangs", "risen", "czars", "milne", "cribs", "genes", "wefts",
				"vents", "sages", "seres", "owens", "wiley", "flume", "haded", "auger", "tatty",
				"onion", "cater", "wolfe", "magic", "bodes", "gulls", "gazes", "dandy", "snags",
				"rowed", "quell", "spurn", "shore", "veldt", "turns", "slavs", "coach", "stalk",
				"snuck", "piles", "orate", "joyed", "daily", "crone", "wager", "solos", "earns",
				"stark", "lauds", "kasey", "villa", "gnaws", "scent", "wears", "fains", "laced",
				"tamer", "pipes", "plant", "lorie", "rivet", "tamed", "cozen", "theme", "lifer",
				"sunny", "shags", "flack", "gassy", "eased", "jeeps", "shire", "fargo", "timer",
				"brash", "behan", "basin", "volga", "krone", "swiss", "docks", "booed", "ebert",
				"gusty", "delay", "oared", "grady", "buick", "curbs", "crete", "lucas", "strum",
				"besom", "gorse", "troth", "donne", "chink", "faced", "ahmed", "texas", "longs",
				"aloud", "bethe", "cacao", "hilda", "eagle", "karyn", "harks", "adder", "verse",
				"drays", "cello", "taped", "snide", "taxis", "kinky", "penes", "wicca", "sonja",
				"aways", "dyers", "bolas", "elfin", "slope", "lamps", "hutch", "lobed", "baaed",
				"masts", "ashes", "ionic", "joyce", "payed", "brays", "malts", "dregs", "leaky",
				"runny", "fecal", "woven", "hurls", "jorge", "henna", "dolby", "booty", "brett",
				"dykes", "rural", "fight", "feels", "flogs", "brunt", "preen", "elvis", "dopey",
				"gripe", "garry", "gamma", "fling", "space", "mange", "storm", "arron", "hairs",
				"rogue", "repel", "elgar", "ruddy", "cross", "medan", "loses", "howdy", "foams",
				"piker", "halts", "jewel", "avery", "stool", "cruel", "cases", "ruses", "cathy",
				"harem", "flour", "meted", "faces", "hobos", "charm", "jamar", "cameo", "crape",
				"hooey", "reefs", "denny", "mitts", "sores", "smoky", "nopes", "sooty", "twirl",
				"toads", "vader", "julep", "licks", "arias", "wrote", "north", "bunks", "heady",
				"batch", "snaps", "claws", "fouls", "faded", "beans", "wimps", "idled", "pulse",
				"goons", "noose", "vowed", "ronda", "rajas", "roast", "allah", "punic", "slows",
				"hours", "metal", "slier", "meaty", "hanna", "curvy", "mussy", "truth", "troys",
				"block", "reels", "print", "miffs", "busts", "bytes", "cream", "otter", "grads",
				"siren", "kilos", "dross", "batty", "debts", "sully", "bares", "baggy", "hippy",
				"berth", "gorky", "argon", "wacko", "harry", "smoke", "fails", "perms", "score",
				"steps", "unity", "couch", "kelly", "rumps", "fines", "mouth", "broth", "knows",
				"becky", "quits", "lauri", "trust", "grows", "logos", "apter", "burrs", "zincs",
				"buyer", "bayer", "moose", "overt", "croon", "ousts", "lands", "lithe", "poach",
				"jamel", "waive", "wiser", "surly", "works", "paine", "medal", "glads", "gybed",
				"paint", "lorre", "meant", "smugs", "bryon", "jinni", "sever", "viols", "flubs",
				"melts", "heads", "peals", "aiken", "named", "teary", "yalta", "styes", "heist",
				"bongs", "slops", "pouts", "grape", "belie", "cloak", "rocks", "scone", "lydia",
				"goofs", "rents", "drive", "crony", "orlon", "narks", "plays", "blips", "pence",
				"march", "alger", "baste", "acorn", "billy", "croce", "boone", "aaron", "slobs",
				"idyls", "irwin", "elves", "stoat", "doing", "globe", "verve", "icons", "trial",
				"olsen", "pecks", "there", "blame", "tilde", "milky", "sells", "tangy", "wrack",
				"fills", "lofty", "truce", "quark", "delia", "stowe", "marty", "overs", "putty",
				"coral", "swine", "stats", "swags", "weans", "spout", "bulky", "farsi", "brest",
				"gleam", "beaks", "coons", "hater", "peony", "huffy", "exert", "clips", "riven",
				"payer", "doped", "salas", "meyer", "dryad", "thuds", "tilts", "quilt", "jetty",
				"brood", "gulch", "corps", "tunic", "hubby", "slang", "wreck", "purrs", "punch",
				"drags", "chide", "sulks", "tints", "huger", "roped", "dopes", "booby", "rosin",
				"outer", "gusto", "tents", "elude", "brows", "lease", "ceres", "laxer", "worth",
				"necks", "races", "corey", "trait", "stuns", "soles", "teems", "scrip", "privy",
				"sight", "minor", "alisa", "stray", "spank", "cress", "nukes", "rises", "gusts",
				"aurae", "karma", "icing", "prose", "biked", "grand", "grasp", "skein", "shaky",
				"clump", "rummy", "stock", "twain", "zoned", "offed", "ghats", "mover", "randy",
				"vault", "craws", "thees", "salem", "downy", "sangs", "chore", "cited", "grave",
				"spinx", "erica", "raspy", "dying", "skips", "clerk", "paste", "moved", "rooks",
				"intel", "moses", "avers", "staid", "yawls", "blast", "lyres", "monks", "gaits",
				"floor", "saner", "waver", "assam", "infer", "wands", "bunch", "dryly", "weedy",
				"honey", "baths", "leach", "shorn", "shows", "dream", "value", "dooms", "spiro",
				"raped", "shook", "stead", "moran", "ditto", "loots", "tapir", "looms", "clove",
				"stops", "pinks", "soppy", "ripen", "wench", "shone", "bauds", "doric", "leans",
				"nadia", "cries", "camus", "boozy", "maris", "fools", "morns", "bides", "greek",
				"gauss", "roget", "lamar", "hazes", "beefy", "dupes", "refed", "felts", "larry",
				"guile", "ables", "wants", "warns", "toils", "bathe", "edger", "paced", "rinks",
				"shoos", "erich", "whore", "tiger", "jumpy", "lamas", "stack", "among", "punts",
				"scalp", "alloy", "solon", "quite", "comas", "whole", "parse", "tries", "reeve",
				"tiled", "deena", "roomy", "rodin", "aster", "twice", "musts", "globs", "parch",
				"drawn", "filch", "bonds", "tells", "droop", "janis", "holds", "scant", "lopes",
				"based", "keven", "whiny", "aspic", "gains", "franz", "jerri", "steel", "rowel",
				"vends", "yelps", "begin", "logic", "tress", "sunni", "going", "barge", "blood",
				"burns", "basks", "waifs", "bones", "skill", "hewer", "burly", "clime", "eking",
				"withs", "capek", "berta", "cheap", "films", "scoot", "tweed", "sizer", "wheat",
				"acton", "flung", "ponds", "tracy", "fiver", "berra", "roger", "mutes", "burke",
				"miked", "valve", "whisk", "runes", "parry", "toots", "japes", "roars", "rough",
				"irons", "romeo", "cages", "reeks", "cigar", "saiph", "dully", "hangs", "chops",
				"rolls", "prick", "acuff", "spent", "sulla", "train", "swell", "frets", "names",
				"anita", "crazy", "sixth", "blunt", "fewer", "large", "brand", "slick", "spitz",
				"rears", "ogres", "toffy", "yolks", "flock", "gnawn", "eries", "blink", "skier",
				"feted", "tones", "snail", "ether", "barbs", "noses", "hears", "upset", "awash",
				"cloud", "trunk", "degas", "dungs", "rated", "shall", "yeahs", "coven", "sands",
				"susan", "fable", "gunny", "began", "serfs", "balls", "dinky", "madge", "prong",
				"spilt", "lilly", "brawn", "comet", "spins", "raids", "dries", "sorts", "makes",
				"mason", "mayra", "royce", "stout", "mealy", "pagan", "nasal", "folds", "libby",
				"coups", "photo", "mosey", "amens", "speed", "lords", "board", "fetal", "lagos",
				"scope", "raked", "bonus", "mutts", "willy", "sport", "bingo", "thant", "araby",
				"bette", "rebel", "gases", "small", "humus", "grosz", "beset", "slays", "steve",
				"scrap", "blahs", "south", "pride", "heels", "tubes", "beady", "lacey", "genus",
				"mauls", "vying", "spice", "sexes", "ester", "drams", "today", "comae", "under",
				"jests", "direr", "yoked", "tempi", "early", "boats", "jesus", "warts", "guppy",
				"gilda", "quota", "token", "edwin", "ringo", "gaped", "lemon", "hurst", "manor",
				"arrow", "mists", "prize", "silas", "blobs", "diets", "ervin", "stony", "buddy",
				"bates", "rabid", "ducat", "ewing", "jaunt", "beads", "doyen", "blush", "thoth",
				"tiles", "piper", "short", "peron", "alley", "decks", "shunt", "whirs", "cushy",
				"roils", "betty", "plugs", "woken", "jibes", "foray", "merak", "ruing", "becks",
				"whale", "shoot", "dwelt", "spawn", "fairs", "dozed", "celts", "blond", "tikes",
				"sabin", "feint", "vamps", "cokes", "willa", "slues", "bills", "force", "curst",
				"yokel", "surer", "miler", "fices", "arced", "douse", "hilly", "lucio", "tongs",
				"togas", "minty", "sagas", "pates", "welsh", "bruno", "decal", "elate", "linux",
				"gyros", "pryor", "mousy", "pains", "shake", "spica", "pupal", "probe", "mount",
				"shirk", "purus", "kilns", "rests", "graze", "hague", "spuds", "sweep", "momma",
				"burch", "maces", "samar", "brace", "riser", "booms", "build", "camel", "flyer",
				"synge", "sauna", "tonga", "tings", "promo", "hides", "clair", "elisa", "bower",
				"reins", "diann", "lubed", "nulls", "picks", "laban", "milch", "buber", "stomp",
				"bosom", "lying", "haled", "avert", "wries", "macon", "skids", "fumed", "ogles",
				"clods", "antic", "nosey", "crimp", "purge", "mommy", "cased", "taxes", "covet",
				"clack", "butch", "panty", "lents", "machs", "exude", "tooth", "adore", "shuck",
				"asses", "after", "terra", "dices", "aryan", "regor", "romes", "stile", "cairo",
				"maura", "flail", "eaves", "estes", "sousa", "visas", "baron", "civet", "kitty",
				"freed", "ralph", "tango", "gawks", "cheat", "study", "fancy", "fiber", "musks",
				"souse", "brims", "claim", "bikes", "venue", "sired", "thymi", "rivas", "skimp",
				"pleas", "woman", "gimpy", "cawed", "minos", "pints", "knock", "poked", "bowen",
				"risky", "towel", "oinks", "linus", "heals", "pears", "codas", "inner", "pitch",
				"harpy", "niger", "madly", "bumpy", "stair", "files", "nobel", "celli", "spars",
				"jades", "balmy", "kooky", "plums", "trues", "gloss", "trims", "daunt", "tubby",
				"dared", "wadis", "smell", "darby", "stink", "drill", "dover", "ruler", "laden",
				"dikes", "layla", "fells", "maker", "joked", "horns", "these", "baize", "spahn",
				"whens", "edged", "mushy", "plume", "tucks", "spurs", "husky", "dried", "bigot",
				"pupas", "drily", "aware", "hagar", "newly", "knots", "pratt", "feces", "sabik",
				"watts", "cooke", "riles", "seamy", "fleas", "dusts", "barfs", "roans", "pawns",
				"vivid", "kirks", "tania", "feral", "tubae", "horne", "aries", "brits", "combs",
				"chunk", "stork", "waned", "texan", "elide", "glens", "emery", "autos", "trams",
				"dosed", "cheri", "baits", "jacks", "whose", "fazed", "matte", "swans", "maxed",
				"write", "spays", "orion", "traci", "horse", "stars", "strut", "goods", "verge",
				"scuff", "award", "dives", "wires", "burnt", "dimly", "sleds", "mayan", "biped",
				"quirk", "sofia", "slabs", "waste", "robby", "mayor", "fatty", "items", "bowel",
				"mires", "swarm", "route", "swash", "sooth", "paved", "steak", "upend", "sough",
				"throw", "perts", "stave", "carry", "burgs", "hilts", "plane", "toady", "nadir",
				"stick", "foist", "gnarl", "spain", "enter", "sises", "story", "scarf", "ryder",
				"glums", "nappy", "sixes", "honed", "marcy", "offer", "kneel", "leeds", "lites",
				"voter", "vince", "bursa", "heave", "roses", "trees", "argos", "leann", "grimy",
				"zelma", "crick", "tract", "flips", "folks", "smote", "brier", "moore", "goose",
				"baden", "riled", "looks", "sober", "tusks", "house", "acmes", "lubes", "chows",
				"neath", "vivas", "defer", "allay", "casey", "kmart", "pests", "proms", "eying",
				"cider", "leave", "shush", "shots", "karla", "scorn", "gifts", "sneer", "mercy",
				"copes", "faxed", "spurt", "monet", "awoke", "rocky", "share", "gores", "drawl",
				"tears", "mooed", "nones", "wined", "wrens", "modem", "beria", "hovel", "retch",
				"mates", "hands", "stymy", "peace", "carat", "coots", "hotel", "karen", "hayed",
				"mamet", "cuing", "paper", "rages", "suave", "reuse", "auden", "costs", "loner",
				"rapes", "hazel", "rites", "brent", "pumps", "dutch", "puffs", "noons", "grams",
				"teats", "cease", "honda", "pricy", "forgo", "fleck", "hired", "silos", "merge",
				"rafts", "halon", "larks", "deere", "jello", "cunts", "sifts", "boner", "morin",
				"mimes", "bungs", "marie", "harts", "snobs", "sonic", "hippo", "comes", "crops",
				"mango", "wrung", "garbs", "natty", "cents", "fitch", "moldy", "adams", "sorta",
				"coeds", "gilds", "kiddy", "nervy", "slurp", "ramon", "fuzed", "hiker", "winks",
				"vanes", "goody", "hawks", "crowd", "bract", "marla", "limbs", "solve", "gloom",
				"sloop", "eaton", "memos", "tames", "heirs", "berms", "wanes", "faint", "numbs",
				"holes", "grubs", "rakes", "waist", "miser", "stays", "antis", "marsh", "skyed",
				"payne", "champ", "jimmy", "clues", "fatal", "shoed", "freon", "lopez", "snowy",
				"loins", "stale", "thank", "reads", "isles", "grill", "align", "saxes", "rubin",
				"rigel", "walls", "beers", "wispy", "topic", "alden", "anton", "ducts", "david",
				"duets", "fries", "oiled", "waken", "allot", "swats", "woozy", "tuxes", "inter",
				"dunne", "known", "axles", "graph", "bumps", "jerry", "hitch", "crews", "lucia",
				"banal", "grope", "valid", "meres", "thick", "lofts", "chaff", "taker", "glues",
				"snubs", "trawl", "keels", "liker", "stand", "harps", "casks", "nelly", "debby",
				"panes", "dumps", "norma", "racks", "scams", "forte", "dwell", "dudes", "hypos",
				"sissy", "swamp", "faust", "slake", "maven", "lowed", "lilts", "bobby", "gorey",
				"swear", "nests", "marci", "palsy", "siege", "oozes", "rates", "stunt", "herod",
				"wilma", "other", "girts", "conic", "goner", "peppy", "class", "sized", "games",
				"snell", "newsy", "amend", "solis", "duane", "troop", "linda", "tails", "woofs",
				"scuds", "shies", "patti", "stunk", "acres", "tevet", "allen", "carpi", "meets",
				"trend", "salty", "galls", "crept", "toner", "panda", "cohen", "chase", "james",
				"bravo", "styed", "coals", "oates", "swami", "staph", "frisk", "cares", "cords",
				"stems", "razed", "since", "mopes", "rices", "junes", "raged", "liter", "manes",
				"rearm", "naive", "tyree", "medic", "laded", "pearl", "inset", "graft", "chair",
				"votes", "saver", "cains", "knobs", "gamay", "hunch", "crags", "olson", "teams",
				"surge", "wests", "boney", "limos", "ploys", "algae", "gaols", "caked", "molts",
				"glops", "tarot", "wheal", "cysts", "husks", "vaunt", "beaus", "fauns", "jeers",
				"mitty", "stuff", "shape", "sears", "buffy", "maced", "fazes", "vegas", "stamp",
				"borer", "gaged", "shade", "finds", "frock", "plods", "skied", "stump", "ripes",
				"chick", "cones", "fixed", "coled", "rodeo", "basil", "dazes", "sting", "surfs",
				"mindy", "creak", "swung", "cadge", "franc", "seven", "sices", "weest", "unite",
				"codex", "trick", "fusty", "plaid", "hills", "truck", "spiel", "sleek", "anons",
				"pupae", "chiba", "hoops", "trash", "noted", "boris", "dough", "shirt", "cowls",
				"seine", "spool", "miens", "yummy", "grade", "proxy", "hopes", "girth", "deter",
				"dowry", "aorta", "paean", "corms", "giant", "shank", "where", "means", "years",
				"vegan", "derek", "tales" };
	
		Set<String> wordList = new HashSet<>();
		for (String w : words) {
			wordList.add(w);
		}

		long t1=System.currentTimeMillis();
		int res = solution.ladderLength(beginWord, endWord, wordList);
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
		System.out.println(res);

	}

}
