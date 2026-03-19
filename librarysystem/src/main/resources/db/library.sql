-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1:3306
-- 產生時間： 2026 年 03 月 19 日 15:38
-- 伺服器版本： 12.1.2-MariaDB-ubu2404
-- PHP 版本： 8.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `library`
--
CREATE DATABASE IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;
USE `library`;

-- --------------------------------------------------------

--
-- 資料表結構 `book`
--

CREATE TABLE `book` (
  `ISBN` varchar(13) NOT NULL,
  `name` varchar(255) NOT NULL,
  `author` varchar(20) NOT NULL,
  `introduction` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- 傾印資料表的資料 `book`
--

INSERT INTO `book` (`ISBN`, `name`, `author`, `introduction`) VALUES
('9786263842786', '眾神之島3', '光風', '島嶼上的神與人，都有了牽掛。\r\n \r\n與神相隨的島民日常，最療癒的「厝邊」故事集！\r\n \r\n電母、太陰娘娘、床母、宮娥、觀世音菩薩、九天玄女\r\n收錄｜六篇短篇、六篇島嶼上的神祇附錄\r\n \r\n★授權韓文版、影視版權\r\n★Readmoo年度華文大獎文學類首獎得主\r\n★文化部中小學生讀物選介得主\r\n \r\n \r\n「全台灣的廟宇遠比超商還多，\r\n等於在生活中遇見一間宮廟，比去便利商店還容易！」\r\n \r\n \r\n在這座「眾神之島」上，我們習慣了與神相鄰的日常。\r\n神恩未必有形，但在某些混沌的時刻裡，又確實感覺被接住。\r\n人心或許脆弱，卻於某些黯淡的角落中，又展現出超凡意志。\r\n於是同在的神與人，都有了牽掛。\r\n \r\n成長的祝福、緣分的連繫，人間煙火，無一處不是惦念。\r\n廟宇修復、手工製香，和神祇息息相關的產業，亦是人腳踏實地的生活。\r\n \r\n善於捕捉人們心底的隱約「微光」，融合「台味幽默」，光風以民間信仰為主題，描繪出電母、太陰娘娘、床母、宮娥、觀世音菩薩、九天玄女，與台灣這塊土地的連結。\r\n《眾神之島》是一部細數台灣生活景象的故事集，講述最平凡的人，最俗常的事，還有最樸素的盼望。\r\n \r\n神在人間，身在此地，俗世的凡塵和煙火氣，都是島嶼的日常天光。'),
('9786264024020', '他從凜冬來', '布丁琉璃', '她愛的少年，深陷暗無天日的凜冬，\r\n她願將自己的光與溫暖分給他，陪伴他從凜冬歸來──\r\n \r\n★《嫁反派》人氣作者　布丁琉璃　現代言情力作──凜凜冬日療癒獻映！\r\n★孤冷武術運動員　沈肆×溫柔陪伴小青梅　童妍\r\n \r\n（上）\r\n \r\n十七歲的童妍，回到兒時生活的城市，轉學到新的高中。\r\n第一天上學，她就在地下道裡撞見一群人鬥毆。\r\n當中那名少年，渾身冷冽，出手凶悍，藍白色制服上濺了血。\r\n這幅畫面本該令人寒顫，童妍卻久久忘不了少年陰鬱的眼神。\r\n \r\n後來，童妍發現，那名少年與她同班，\r\n她成了他的鄰座同學，他有著童妍熟悉的名字──沈肆。\r\n兒時記憶湧上心頭，那個開朗的鄰居男孩，與如今叛逆冷傲的少年截然不同。\r\n原本幸福溫暖的家庭，只剩下學生資料表上空蕩蕩的家屬欄位。\r\n以及新聞中，背負著違規罵名而殞落的武術運動天才。\r\n童妍忍不住好奇，究竟是什麼讓沈肆變成這個模樣？\r\n \r\n第一次見到童妍，沈肆就認出了她，卻也勾起他此生最無助的回憶。\r\n他早已不是當年那個無憂無慮的男孩，\r\n身負血腥黑暗與無盡絕望，落入凜冽寒冬，再也無法走出去。\r\n可是那個女孩再次來到他的生命中，\r\n頑強地、不顧他拒絕地，散發柔光與溫暖，\r\n使他冰封已久的心，逐漸消融，生出嚮往與渴望……\r\n \r\n（下）\r\n \r\n沈肆背負著沉重的身世，\r\n因而失去父親，目睹母親倒臥血泊，連立足於光明中的資格都被剝奪。\r\n童妍卻不顧一切，天真、溫柔、執拗地靠近他。\r\n她為他的比賽寫下──少年長槍破空，劍指蒼穹。\r\n她在學校天臺上大聲說，想與他和好做朋友。\r\n她為他拂去肩頭白雪，堅定與他並肩同行。\r\n她在煙火下，眸中閃著瀅瀅碎光，對著他笑，\r\n令他再也忍不住，彎下腰親吻這溫柔美好的女孩，\r\n哪怕黑暗並未遠去，他仍想竊取這一瞬的光芒。\r\n \r\n童妍總摸不清沈肆的忽冷忽熱，\r\n每次覺得離他更近了一點時，又會馬上被沈肆推開，\r\n但她敏銳地察覺，少年並不是厭棄她，而是害怕失去。\r\n直到沈肆親口說出自己不為人知的過往……\r\n \r\n童妍是沈肆這一生唯一的溫暖與渴求，\r\n可黑暗從來不放過他，甚至想將魔爪伸向他最珍愛的女孩。\r\n當現實打碎一切希冀，沈肆唯一能做的，\r\n便是投身黑暗，換得女孩平安、光明。\r\n待他從凜冬歸來，他將重返賽場，取得榮耀，\r\n獻給此生唯一摯愛──'),
('9786264091886', '矛盾', '梁貴子', '人生不論你組裝得再完美，\r\n一旦拆開後，就只剩下矛盾。\r\n願我們都在矛盾裡誠實地活。\r\n \r\n—台灣版典藏禮物書特殊裝幀\r\n—擊凸加工針線效果傳達人的溫度\r\n \r\n✦ 世紀末年度暢銷小說，2020年揭開「無宣傳」逆襲的奇蹟篇章\r\n✦ 長踞「教保文庫」韓國小說TOP 1，2025年度之書TOP2\r\n✦ 銷售170萬+ 冊，掀起社群媒體金句分享熱潮\r\n \r\n◆\r\n \r\n「矛盾」是人生的真相。\r\n所有的拉扯，不是系統錯亂，是你認真活著的證據。\r\n \r\n我是安真真，25歲，未婚，身材不高不矮，相貌雖然不是不堪入目，但也沒到令人驚艷的地步。\r\n我自認讀了不少書，腦袋裡還是裝了一些東西，然後⋯⋯\r\n就沒有然後了。\r\n我的人生毫無深度，連一粒芝麻也容不下——\r\n這樣活著，真的沒有問題嗎？\r\n◆\r\n每一個矛盾都對應一個選擇，\r\n但生活從來都不是關於答案。\r\n人生總會有這麼一天，覺得不能再這樣活下去。當那天突然到來，我開始回顧自己不算長的人生。\r\n我的母親有個雙胞胎妹妹。她們在四月一日愚人節出生，也在四月一日同一天結婚，從此走上不同的人生之路。母親嫁給無拘無束、熱愛自由的男人，婚後才發現這男人是個酒鬼，還經常搞消失，如今已經下落不明五年。媽媽靠著在市場賣襪子、內衣過活，養大我和弟弟。\r\n相反的，阿姨嫁給了菸酒不沾的建築師，一個無聊又完全可以預測的人。他每天準時下班回家，而且陪阿姨過所有的節日。阿姨是個很浪漫的人，喜歡使用「珍藏」和「永遠」這種詞彙，而母親最常掛在嘴邊的是「利益」和「計算」。\r\n看著母親和阿姨天差地別的生活，我也不知不覺面臨了必須在兩個男人之間做出選擇的難題：羅英奎是計畫狂，人生的一切都在他的計畫中，包括我的反應、我們的回憶。相反的，金章宇嚮往自由，從來不做計畫，永遠跟著感覺走——他和我父親就像照鏡子一樣相像，可明明知道下場，我的心卻還是往金章宇傾斜……\r\n \r\n幸 vs. 不幸、愛vs.不愛……矛盾是世間萬物的真理；\r\n理性 vs. 感性、自由 vs. 責任……沒有一條道路能保證任何事。\r\n \r\n矛和盾，是所有事物的兩面，永遠無法對齊。\r\n我們不必與自己和解，只要誠實面對——至少活得像我們自己。'),
('9786267854099', '借一場天色愛你', '晨羽', '即使起霧下雨，天色變幻，\r\n\r\n跟你在一起的時光，只有更耀眼。\r\n\r\n \r\n\r\n我們預測得了氣候，\r\n\r\n卻永遠無法預測心動。\r\n \r\n\r\n流星、極光、風雪、彩虹，\r\n\r\n承載了「相信」的信念，\r\n\r\n相信能找到幸福，\r\n\r\n所以我們時刻追尋。\r\n\r\n \r\n\r\n那些突如其來的悸動、\r\n\r\n那些無法抵抗的酸甜苦澀，\r\n\r\n都藏匿在風與雲、光與影的變幻之中\r\n\r\n不管天氣好，不管天氣不好，\r\n\r\n只要看見，彷彿聽見你說：\r\n\r\n我喜歡你。'),
('9789573343608', '銀雪輪舞曲', '東野圭吾', '我經歷過的種種不幸，\r\n你們全都給我品嘗一遍！\r\n\r\n日本上市10天銷售突破100萬冊！\r\n攻占ORICON公信榜銷售冠軍！\r\n\r\n東野圭吾「雪地三部曲」\r\n承先啟後的現象級之作！\r\n\r\n改編拍成電影，\r\n由阿部寬、大倉忠義、大島優子領銜主演！\r\n\r\n新裝典藏．全新譯本\r\n§ 特別收錄 §\r\n東野圭吾短語 ╳ 印簽扉頁\r\n\r\n❈　❈　❈\r\n\r\n　　遺失的物品就在我手中。\r\n　　只要答應我的要求，就會告知埋藏地點。\r\n　　我的要求是：三億日圓。\r\n　　――K-55\r\n\r\n　　看著這封匿名信，東鄉所長嚇得魂飛魄散。\r\n\r\n　　安放在實驗室裡的「K-55」炭疽桿菌竟然失竊，還被藏在雪地深處，當氣溫上升超過10度，病毒就會因容器破裂而逸出，造成大規模的死傷。不想報警，又無計可施的東鄉正準備討價還價，沒想到卻接到通報：歹徒因車禍意外身亡！\r\n\r\n　　現在，所有的希望都落在研究員栗林身上。雖然滑雪技術極差，他仍被東鄉派往一座可疑的滑雪場，受命回收病毒。但他掌握的線索，只有幾張沒有關鍵地標的雪景照，以及照片中那一隻會發射訊號的泰迪熊。\r\n\r\n　　隨著調查越來越深入，栗林也發現，這座雪場的平靜表面下，暗藏著一個不為人知的秘密。但最教他恐懼的是，午夜夢回，腦中反覆出現的那幅景象——K-55試管破裂，超微粒子隨著春風飄散至山腳下，所有居民都染上了炭疽病……這場無可挽回的災難，是否即將降臨？\r\n\r\n　　❈　❈　❈\r\n\r\n　　每一個人都有屬於自己的人生雪道，\r\n　　當雪煙漫天揚起的那一刻，\r\n　　我們已在不知不覺中，跌入了人性的深淵……\r\n\r\n　　在《白雪之劫》的「炸彈」與《雪煙追逐》的「命案」之間，東野圭吾以充滿速度感的劇情、逼真的滑雪場景，以及駭人的「病毒」巧妙串接，為「雪地三部曲」的人性追逐戰掀起另一波高潮。幸與不幸，往往是一體兩面，就如同書中所說的——人不能因為有人遭遇不幸，就放棄去追求自己的幸福。因為擊垮我們的往往不是病毒，而是那善惡難辨的人性。'),
('9789573343769', '架空犯', '東野圭吾', '東野圭吾：\r\n我原以為，應該不會有把這個題材做成作品的一天。\r\n \r\n東野圭吾出道40週年紀念　\r\n \r\n＼《天鵝與蝙蝠》系列重磅新作！／\r\n＼系列暢銷突破130萬冊！／\r\n＼橫掃東販、日販、紀伊國屋、淳久堂、三省堂等各大排行榜TOP 1！／\r\n \r\n▍比找出幽靈更難的，\r\n▍是證明幽靈根本不存在。\r\n \r\n被燒得焦黑的房子裡，兩具遺體陳屍其中。面目全非的男性脖子上有繩狀灰燼，女性則是遭勒斃後偽裝成在浴室上吊。不僅現場怵目驚心，死者的身分也讓眾人繃緊神經──東京都議會議員藤堂康幸與他的妻子，曾紅極一時的女明星雙葉江利子。\r\n \r\n警方全力動員，警視廳的五代與首次搭檔的警察山尾，走訪各地調查被害人的人際關係。原來藤堂夫婦曾是同一所高中的老師與學生。而越是深入了解，五代越是有種強烈預感，關鍵線索就藏在藤堂夫婦四十多年前的青春時代。\r\n \r\n不願放過任何疑點的五代，卻沒想到最可疑的竟是身邊這位搭檔。明明自稱對藤堂夫婦一點都不熟悉，山尾卻不經意表現出好像認識江利子很久的樣子，也似乎對藤堂議員的政治生涯很了解。不只如此，他更隱瞞了一個非常重大的情報⋯⋯\r\n \r\n當所有人都在為了逐漸浮出的真相奔忙著，五代卻更想知道真相背後的「為什麼」。因為就算是犯人，也有屬於犯人的存在意義──\r\n \r\n▍也許我存在的意義，\r\n▍就是為了你，成為不存在的那個人。\r\n \r\n為一個人存在，是不問結果拚命愛著，是不惜犧牲誓死守護。\r\n是比起愛得滿身是傷，不如永遠單戀更幸福。\r\n是即使要活得像從不存在過，卻依然感到滿足。\r\n是什麼讓小說裡的他們，如此選擇，如此堅持，又如此愛？\r\n東野圭吾透過耿直刑警的腳步，梳理因緣的線，解開人情的結──\r\n世界如此現實又黑暗，真的有照進光的可能嗎？');

-- --------------------------------------------------------

--
-- 資料表結構 `borrow_record`
--

CREATE TABLE `borrow_record` (
  `borrow_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `inventory_id` bigint(20) DEFAULT NULL,
  `borrow_time` datetime NOT NULL,
  `return_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- 傾印資料表的資料 `borrow_record`
--

INSERT INTO `borrow_record` (`borrow_id`, `user_id`, `inventory_id`, `borrow_time`, `return_time`) VALUES
(1, 1, 1, '2026-03-19 16:49:11', '2026-03-19 16:59:12'),
(2, 1, 4, '2026-03-19 23:32:33', NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `inventory`
--

CREATE TABLE `inventory` (
  `inventory_id` bigint(20) NOT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `store_time` datetime NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- 傾印資料表的資料 `inventory`
--

INSERT INTO `inventory` (`inventory_id`, `ISBN`, `store_time`, `status`) VALUES
(1, '9786263842786', '2026-03-19 05:45:53', 'STOCK'),
(2, '9786264024020', '2026-03-19 05:46:59', 'CLASSIFICATION'),
(3, '9786264091886', '2026-03-19 05:46:59', 'DAMAGED'),
(4, '9786267854099', '2026-03-19 05:48:04', 'LOAN'),
(5, '9789573343608', '2026-03-19 05:48:42', 'STOCK');

-- --------------------------------------------------------

--
-- 資料表結構 `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `phonenumber` varchar(10) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `registration_time` datetime DEFAULT current_timestamp(),
  `last_login` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- 傾印資料表的資料 `users`
--

INSERT INTO `users` (`user_id`, `phonenumber`, `password`, `username`, `email`, `registration_time`, `last_login`) VALUES
(1, '0909278872', '12345678', 'user1', 'peggy7777@gmail.com', '2026-03-18 20:34:56', NULL),
(2, '0909278871', '12345678', 'user2', 'mang123456@gmail.com', '2026-03-18 21:01:49', NULL),
(4, '0909278877', '12345678', 'user3', 'mang123456@gmail.com', '2026-03-18 21:04:50', NULL),
(5, '0909278815', '12345678', 'user4', 'mang123456@gmail.com', '2026-03-18 21:05:59', NULL);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ISBN`);

--
-- 資料表索引 `borrow_record`
--
ALTER TABLE `borrow_record`
  ADD PRIMARY KEY (`borrow_id`),
  ADD KEY `fk_borrow_user` (`user_id`),
  ADD KEY `fk_borrow_inventory` (`inventory_id`);

--
-- 資料表索引 `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventory_id`),
  ADD KEY `ISBN` (`ISBN`);

--
-- 資料表索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `borrow_record`
--
ALTER TABLE `borrow_record`
  MODIFY `borrow_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inventory_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `borrow_record`
--
ALTER TABLE `borrow_record`
  ADD CONSTRAINT `fk_borrow_inventory` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`inventory_id`),
  ADD CONSTRAINT `fk_borrow_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- 資料表的限制式 `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `1` FOREIGN KEY (`ISBN`) REFERENCES `book` (`ISBN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
