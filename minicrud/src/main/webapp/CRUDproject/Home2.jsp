<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<style>
@import
	url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;600;700&display=swap")
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Roboto', sans-serif;
}

body {	
	background-color: rgba(0, 0, 0, 0.8);
	color: #fff;
	margin: 0;
}

nav {
	padding: 50px;
	position: fixed;
	width: 100%;
	z-index: 1000;
	position: relative;
}

nav img {
	width: 167px;
}

.main-content {
	margin-top: 150px; /* nav 높이만큼 여백 */
	padding: 30px;
}

h1 {
	font-size: 2rem;
	margin-bottom: 20px;
	margin-top: 0;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #555;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #333;
	color: #fff;
}

td img {
	max-width: 100px;
	height: auto;
}
.movieBox-list {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}

.movieBox-item {
  margin-top: 25px;
  width: calc(50% - 7.5px);
  overflow: hidden;
}

.movieBox-item:nth-child(2n) {
  margin-right: 0;
}

.movieBox-item > a {
  position: relative;
  display: inline-block;
  overflow: hidden;
  width: 100%;
  border-radius: 3px;
}

.movieBox-item > a > img {
  width: 310px;
  height: 380px;
}

</style>
</head>
<body>
	<nav>
		<a href="#"><img src="images/logo.svg" alt="logo"></a>
	</nav>
	<div class="main-content">
		<h1>스릴러 영화 TOP20</h1>
		<div class="wArea space">
			<div class="movieBox">
				<ul class="movieBox-list">
					<li class="movieBox-item"><a
						href="#">
							<img src="images/기생충.jpeg" alt="기생충">
							<p class="rank realtime_rank23">1위</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age ageall"></span>
								<h3>
									<a
										href="#">기생충</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>57.70%</span></li>
								<li class="movie-launch">개봉일 2024.06.12</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="images/인셉션.jpeg" alt="인셉션">
							<p class="rank realtime_rank23">2</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age12"></span>
								<h3>
									<a
										href="#">인셉션</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>14.80%</span></li>
								<li class="movie-launch">개봉일 2024.06.21</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="images/그녀가 죽었다.jpg" alt="그녀가 죽었다">
							<p class="rank realtime_rank23">3</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">그녀가 죽었다</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>4.50%</span></li>
								<li class="movie-launch">개봉일 2024.06.26</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="images/파묘.jpg" alt="파묘">
							<p class="rank realtime_rank23">4</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">파묘</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>3.70%</span></li>
								<li class="movie-launch">개봉일 2024.06.26</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(4)" alt="극장판 하이큐!! 쓰레기장의 결전">
							<p class="rank realtime_rank23">5</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age ageall"></span>
								<h3>
									<a
										href="#">극장판
										하이큐!! 쓰레기장의 결전</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>2.80%</span></li>
								<li class="movie-launch">개봉일 2024.05.15</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(5)" alt="존 오브 인터레스트">
							<p class="rank realtime_rank23">6</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age12"></span>
								<h3>
									<a
										href="#">존
										오브 인터레스트</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>1.00%</span></li>
								<li class="movie-launch">개봉일 2024.06.05</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(6)" alt="프렌치 수프">
							<p class="rank realtime_rank23">7</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age12"></span>
								<h3>
									<a
										href="#">프렌치
										수프</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.80%</span></li>
								<li class="movie-launch">개봉일 2024.06.19</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(7)" alt="북극백화점의 안내원">
							<p class="rank realtime_rank23">8</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age ageall"></span>
								<h3>
									<a
										href="#">북극백화점의
										안내원</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.80%</span></li>
								<li class="movie-launch">개봉일 2024.06.19</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(8)" alt="밤낚시">
							<p class="rank realtime_rank23">9</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age ageall"></span>
								<h3>
									<a
										href="#">밤낚시</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.70%</span></li>
								<li class="movie-launch">개봉일 2024.06.14</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(9)" alt="퓨리오사: 매드맥스 사가">
							<p class="rank realtime_rank23">10</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">퓨리오사:
										매드맥스 사가</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.70%</span></li>
								<li class="movie-launch">개봉일 2024.05.22</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(10)" alt="1초 앞, 1초 뒤">
							<p class="rank realtime_rank23">11</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age ageall"></span>
								<h3>
									<a
										href="#">1초
										앞, 1초 뒤</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.70%</span></li>
								<li class="movie-launch">개봉일 2024.06.19</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(11)" alt="키타로 탄생 게게게의 수수께끼">
							<p class="rank realtime_rank23">12</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">키타로
										탄생 게게게의 수수께끼</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.60%</span></li>
								<li class="movie-launch">개봉일 2024.06.12</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(12)" alt="프리실라">
							<p class="rank realtime_rank23">13</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">프리실라</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.30%</span></li>
								<li class="movie-launch">개봉일 2024.06.19</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(13)" alt="드라이브">
							<p class="rank realtime_rank23">14</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">드라이브</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.20%</span></li>
								<li class="movie-launch">개봉일 2024.06.12</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(14)" alt="원더랜드">
							<p class="rank realtime_rank23">15</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age12"></span>
								<h3>
									<a
										href="#">원더랜드</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.20%</span></li>
								<li class="movie-launch">개봉일 2024.06.05</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(15)" alt="범죄도시4">
							<p class="rank realtime_rank23">16</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">범죄도시4</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.20%</span></li>
								<li class="movie-launch">개봉일 2024.04.24</li>
							</ul>
							<div class="movie-ticket">
								<a href="https://m.moviechart.co.kr/work/reserve/step1/3290">예매하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="https://m.moviechart.co.kr/info/movieinfo/detail/20225823">
							<img src="./무비차트_files/thumb(16)" alt="카브리올레">
							<p class="rank realtime_rank23">17</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">카브리올레</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.20%</span></li>
								<li class="movie-launch">개봉일 2024.06.19</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(17)" alt="그녀가 죽었다">
							<p class="rank realtime_rank23">18</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age15"></span>
								<h3>
									<a
										href="#">그녀가 죽었다</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.20%</span></li>
								<li class="movie-launch">개봉일 2024.05.15</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(18)" alt="판문점">
							<p class="rank realtime_rank23">19</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age age12"></span>
								<h3>
									<a
										href="#">판문점</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.20%</span></li>
								<li class="movie-launch">개봉일 2024.06.19</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
					<li class="movieBox-item"><a
						href="#">
							<img src="./무비차트_files/thumb(19)" alt="결속밴드 라이브 -항성-">
							<p class="rank realtime_rank23">20</p>
					</a>
						<div class="movie-info">
							<div class="movie-title">
								<span class="movie-age ageall"></span>
								<h3>
									<a
										href="#">결속밴드
										라이브 -항성-</a>
								</h3>
							</div>
							<ul class="movie-txt">
								<li class="ticketing">예매율 <span>0.10%</span></li>
								<li class="movie-launch">개봉일 2024.05.29</li>
							</ul>
							<div class="movie-ticket">
								<a href="#">시청하기</a>
							</div>
						</div></li>
				</ul>
			</div>
			</tbody>
			</table>
		</div>
</body>
</html>
