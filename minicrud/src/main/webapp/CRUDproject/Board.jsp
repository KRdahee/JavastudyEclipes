<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Netflix-Style Bulletin Board</title>
    
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;600;700&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            background-color: #000;
            color: #fff;
            margin: 0;
        }

        nav {
            padding: 40px;
            background-color: #000;
            position: fixed;
            width: 100%;
            z-index: 1000;
            position: relative;
        }

        nav img {
            width: 167px;
        }

        .board-wrapper {
            margin-top: 15px; /* nav 높이만큼 여백 */
            padding: 30px;
        }
		/* 게시판 글씨 크기 바꾸고싶헝ㅎ엏.*/
        h1 {
        	color: #fff;
            font-size: 2.8rem;
            margin-bottom: 20px;
            margin-top: 0;
        }

        .posts {
            margin-bottom: 30px;
        }

        .post {
            background: #282828;
            padding: 20px;
            margin-bottom: 15px;
            border-radius: 5px;
            position: relative;
        }

        .post-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        .post-header h3 {
            font-size: 1.5rem;
        }

        .post-content {
            color: #b3b3b3;
        }

        .post-time {
            color: #ccc;
            font-size: 0.9rem;
            margin-top: 5px;
        }

        .post-options {
            display: flex;
            gap: 10px;
        }

        .delete-btn, .update-btn {
            font-size: 1.0rem;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.2s ease;
        }

        .delete-btn {
            background-color: #e50914;
            color: #fff;
            border: none;
        }

        .delete-btn:hover {
            background-color: #c40812;
        }

        .update-btn {
            background-color: #0071eb;
            color: #fff;
            border: none;
        }

        .update-btn:hover {
            background-color: #005cb2;
        }

        #update-form {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: rgba(0, 0, 0, 0.7);
            padding: 20px;
            border-radius: 5px;
            z-index: 1000;
        }

        #update-form h3 {
            font-size: 1.5rem;
            margin-bottom: 10px;
            color: #fff;
        }

        #update-title,
        #update-content {
            width: 100%;
            padding: 15px;
            margin-bottom: 10px;
            border: none;
            border-radius: 5px;
            background-color: #333;
            color: #fff;
        }

        #update-content {
            height: 200px;
        }

        #update-form button {
            width: 100%;
            padding: 12px 0;
            font-size: 1rem;
            background: #0071eb;
            color: #fff;
            font-weight: 500;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.1s ease;
        }

        #update-form button:hover {
            background: #005cb2;
        }

        @media (max-width: 768px) {
            .board-wrapper {
                padding: 15px;
            }

            .post {
                padding: 15px;
                margin-bottom: 10px;
            }

            .post-header h3 {
                font-size: 1.2rem;
            }

            .post-content {
                font-size: 0.9rem;
            }

            .post-time {
                font-size: 0.8rem;
            }

            .delete-btn, .update-btn {
                font-size: 0.8rem;
                padding: 6px 12px;
            }

            #update-form {
                padding: 15px;
                width: 80%;
                max-width: 400px;
            }

            #update-title, #update-content {
                padding: 10px;
                font-size: 0.9rem;
            }

            #update-content {
                height: 150px;
            }

            #update-form button {
                font-size: 0.9rem;
                padding: 10px 0;
            }
        }
    </style>
</head>
<body>
    <nav>
        <a href="#"><img src="images/logo.svg" alt="logo"></a>
    </nav>
    <div class="board-wrapper">
        <h1>&nbsp;게시판</h1>
        <div class="posts">
            <!-- 예시 게시물 목록 -->
            <div class="post" id="post1">
                <div class="post-header">
                    <h3>안녕하세요! 한국 스릴러 영화를 추천해드려요. 개인의 취향이 반영된 선택입니다 :)</h3>
                    <div class="post-options">
                        <button class="delete-btn" onclick="deletePost('post1')">삭제</button>
                        <button class="update-btn" onclick="showUpdateForm('post1')">수정</button>
                    </div>
                </div><br>
                <p class="post-content">
                TOP 1. 추격자 (네이버 평점 9.09 / 다음 평점 9.1) - 2008<br>
                TOP 2. 기생충 (네이버 평점 9.07 / 다음 평점 7.9) - 2019<br>
                TOP 3. 살인의 추억 (네이버 평점 9.65 / 다음 평점 9.4) - 2003<br>
                TOP 4. 마더 (네이버 평점 9.45 / 다음 평점 8.1) - 2009<br>
                TOP 5. 밀정 (네이버 평점 8.57 / 다음 평점 7.7) - 2016<br>
                TOP 6. 더 테러 라이브 (네이버 평점 8.29 / 다음 평점 8.3) - 2013<br>
                TOP 7. 암수살인 (네이버 평점 8.58 / 다음 평점 7.6) - 2018<br>
                TOP 8. 악마를 보았다 (네이버 평점 8.01 / 다음 평점 6.9) - 2010<br>
                TOP 9. 내가 살인범이다 (네이버 평점 8.48 / 다음 평점 8.6) - 2012<br>
          		TOP 10. 이웃사람 (네이버 평점 7.52 / 다음 평점 8.0) - 2012
                </p><br>
                <p class="post-time">게시 시간:&nbsp;&nbsp;2024-06-21</p>
            </div>

            <div class="post" id="post2">
                <div class="post-header">
                    <h3>"범죄도시5" 2026년에 개봉 예정인 한국 영화!</h3>
                    <div class="post-options">
                        <button class="delete-btn" onclick="deletePost('post2')">삭제</button>
                        <button class="update-btn" onclick="showUpdateForm('post2')">수정</button>
                    </div>
                </div>
                <br>
                <p class="post-content">
                    마동석은 "5편은 대본 작업 중이고 5~8편은 현대적 글로벌 사건 다룰 것"이라고 전했다. "1~4편이 1부라면, 5~8편은 2부로 모양새 자체도 다르고 좀 더 현대적이고 글로벌한 사건을 다루고 있다. 
                    <br>5편 개봉은 시기상 조금 더 지나야 될 것 같다. 1~4편은 년도를 조금 뛰어넘지만 5~8편은 가장 현대에 있는 4가지 이야기를 다룰 예정이다"라며 "현대 사회의 고도화 된 범죄를 다룬다. 
                    <br>어떤 사건을 벌일 때 그것의 원인이 이전엔 아날로그였다면 요새는 디지털화 된다. 사건은 같지만 현대에 맞게 바꿨다"고 말했다. 또한 2부부터는 완전 다른 2부가 될 것이라고 밝혔다.
                </p>
                <br>
                <p class="post-time">게시 시간:&nbsp;&nbsp;2024-06-20</p>
            </div>
            <!-- End 예시 게시물 목록 -->
        </div>
    </div>

    <!-- 수정 폼 -->
    <div id="update-form">
        <h3>게시물 수정</h3>
        <input type="hidden" id="update-post-id">
        <input type="text" id="update-title" placeholder="제목" required><br>
        <textarea id="update-content" placeholder="내용" required></textarea><br>
        <button onclick="updatePost()">수정 완료</button>
    </div>

    <!-- Ajax 및 JavaScript 코드 -->
    <script>
        function deletePost(postId) {
            if (confirm('정말로 이 게시물을 삭제하시겠습니까?')) {
                // Ajax를 사용한 게시물 삭제 요청
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === XMLHttpRequest.DONE) {
                        if (xhr.status === 200) {
                            alert('게시물이 삭제되었습니다.');
                            document.getElementById(postId).remove();
                        } else {
                            alert('게시물 삭제에 실패했습니다.');
                        }
                    }
                };
                xhr.open('POST', 'deletePost.jsp'); // 게시물 삭제 처리 JSP 페이지 경로
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xhr.send('postId=' + postId); // 삭제할 게시물 ID 전송
            }
        }

        function showUpdateForm(postId) {
            var postElement = document.getElementById(postId);
            var title = postElement.querySelector('h3').innerText;
            var content = postElement.querySelector('.post-content').innerText;

            // 수정 폼에 게시물 정보 입력
            document.getElementById('update-post-id').value = postId;
            document.getElementById('update-title').value = title;
            document.getElementById('update-content').value = content;

            // 수정 폼 보이기
            document.getElementById('update-form').style.display = 'block';
        }

        function updatePost() {
            var postId = document.getElementById('update-post-id').value;
            var updatedTitle = document.getElementById('update-title').value;
            var updatedContent = document.getElementById('update-content').value;

            // Ajax를 사용한 게시물 업데이트 요청
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert('게시물이 업데이트되었습니다.');
                        location.reload(); // 페이지 새로고침
                    } else {
                        alert('게시물 업데이트에 실패했습니다.');
                    }
                }
            };
            xhr.open('POST', 'updatePost.jsp'); // 게시물 업데이트 처리 JSP 페이지 경로
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send('postId=' + postId + '&title=' + encodeURIComponent(updatedTitle) + '&content=' + encodeURIComponent(updatedContent)); // 업데이트할 게시물 정보 전송
        }
    </script>
</body>
</html>
