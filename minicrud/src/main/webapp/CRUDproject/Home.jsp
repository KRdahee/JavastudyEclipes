<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Netflix-Style</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;600;700&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            background: #000;
            color: #fff;
            margin: 0;
        }

        nav {
            padding: 50px;
            background-color: rgba(0, 0, 0, 0.8);
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
    </style>
</head>
<body>
    <nav>
        <a href="#"><img src="images/logo.svg" alt="logo"></a>
    </nav>
    <div class="main-content">
        <h1>넷플릭스 스타일 홈</h1>
        <table>
            <thead>
                <tr>
                    <th>포스터</th>
                    <th>제목</th>
                    <!-- <th>평점</th>
                    <th>시청자 수</th> -->
                </tr>
            </thead>
            <tbody>
                <!-- 예시 영화 목록 -->
                <% 
                    // 예시 영화 데이터
                    String[] movieTitles = {"23아이텐디티", "영화 제목 2", "영화 제목 3", "영화 제목 4", "영화 제목 5",
                                            "영화 제목 6", "영화 제목 7", "영화 제목 8", "영화 제목 9", "영화 제목 10",
                                            "영화 제목 11", "영화 제목 12", "영화 제목 13", "영화 제목 14", "영화 제목 15",
                                            "영화 제목 16", "영화 제목 17", "영화 제목 18", "영화 제목 19", "영화 제목 20",
                                            "영화 제목 21", "영화 제목 22", "영화 제목 23", "영화 제목 24", "영화 제목 25",
                                            "영화 제목 26", "영화 제목 27", "영화 제목 28", "영화 제목 29", "영화 제목 30"};

                    String[] moviePosters = {"23아이덴티티.jpg", "poster2.jpg", "poster3.jpg", "poster4.jpg", "poster5.jpg",
                                             "poster6.jpg", "poster7.jpg", "poster8.jpg", "poster9.jpg", "poster10.jpg",
                                             "poster11.jpg", "poster12.jpg", "poster13.jpg", "poster14.jpg", "poster15.jpg",
                                             "poster16.jpg", "poster17.jpg", "poster18.jpg", "poster19.jpg", "poster20.jpg",
                                             "poster21.jpg", "poster22.jpg", "poster23.jpg", "poster24.jpg", "poster25.jpg",
                                             "poster26.jpg", "poster27.jpg", "poster28.jpg", "poster29.jpg", "poster30.jpg"};

                    // 예시 평점 (랜덤하게 설정)
                    double[] ratings = {8.5, 7.9, 9.2, 8.1, 8.7, 7.5, 8.9, 7.8, 9.1, 8.3,
                                        8.6, 7.7, 8.4, 9.0, 7.6, 8.8, 8.2, 9.3, 7.4, 8.0,
                                        8.5, 7.9, 9.2, 8.1, 8.7, 7.5, 8.9, 7.8, 9.1, 8.3};

                    // 예시 시청자 수 (랜덤하게 설정)
                    int[] viewers = {1500000, 1200000, 1800000, 1350000, 1650000, 1100000, 1750000, 1250000, 1850000, 1400000,
                                     1550000, 1150000, 1700000, 1300000, 1600000, 1050000, 1700000, 1900000, 1000000, 1450000,
                                     1500000, 1200000, 1800000, 1350000, 1650000, 1100000, 1750000, 1250000, 1850000, 1400000};

                    // 영화 목록 출력
                    for (int i = 0; i < movieTitles.length; i++) {
                        String title = movieTitles[i];
                        String poster = moviePosters[i];
                        double rating = ratings[i];
                        int viewerCount = viewers[i];
                %>
                    <tr>
                        <td><img src="images/<%= poster %>" alt="<%= title %>"></td>
                        <td><%= title %></td>
                        <!-- <td><%= rating %> / 10</td>
                        <td><%= viewerCount %></td> -->
                    </tr>
                <% } %>
                <!-- End 예시 영화 목록 -->
            </tbody>
        </table>
    </div>
</body>
</html>
