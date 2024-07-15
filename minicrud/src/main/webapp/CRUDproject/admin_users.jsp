<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Netflix 회원 관리</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;600;700&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            background: #ff0;
        }

        body::before {
            content: "";
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0.3;
            width: 100%;
            height: 100%;
            background: url("images/hero-img.jpg");
            background-position: center;
        }

        nav {
            position: fixed;
            padding: 25px 60px;
            z-index: 1;
        }

        nav a img {
            width: 167px;
        }

        .table-wrapper {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            width: 800px;
            background: rgba(0, 0, 0, .75);
            border-radius: 4px;
            padding: 30px;
        }

        .table-wrapper h2 {
            color: #fff;
            font-size: 2rem;
            margin-bottom: 20px;
        }

        .member-table {
            width: 100%;
            border-collapse: collapse;
        }

        .member-table th,
        .member-table td {
            border: 1px solid #444;
            padding: 10px;
            text-align: center;
            color: #fff;
        }

        .member-table th {
            background-color: #333;
        }

        .member-table td {
            background-color: #555;
        }

        .member-table tr:hover {
            background-color: #777;
        }

        .button-group {
            margin-top: 20px;
            text-align: center;
        }

        .button-group button {
            padding: 10px 20px;
            font-size: 1rem;
            background: #e50914;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: 0 10px;
            transition: background 0.1s ease;
        }

        .button-group button:hover {
            background: #c40812;
        }

        @media (max-width: 900px) {
            body::before {
                display: none;
            }

            nav, .table-wrapper {
                padding: 20px;
            }

            nav a img {
                width: 140px;
            }

            .table-wrapper {
                width: 100%;
                top: 43%;
            }
        }
    </style>
</head>
<body>
    <nav>
        <a href="#"><img src="images/logo.svg" alt="logo"></a>
    </nav>
    <div class="table-wrapper">
        <h2>회원 관리</h2>
        <table class="member-table">
            <thead>
                <tr>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>가입일</th>
                    <th>관리</th>
                </tr>
            </thead>
            <tbody>
                <!-- 예시 데이터 -->
                <tr>
                    <td>Dahee Lee</td>
                    <td>dahee188@gmail.com</td>
                    <td>2016-11-13</td>
                    <td>
                        <button>수정</button>
                        <button>삭제</button>
                    </td>
                </tr>
                <tr>
                    <td>John Doe</td>
                    <td>johndoe@daum.net</td>
                    <td>2024-06-21</td>
                    <td>
                        <button>수정</button>
                        <button>삭제</button>
                    </td>
                </tr>
                <tr>
                    <td>Jane Smith</td>
                    <td>janesmith@naver.com</td>
                    <td>2020-08-02</td>
                    <td>
                        <button>수정</button>
                        <button>삭제</button>
                    </td>
                </tr>
                <tr>
                    <td>Chris Love</td>
                    <td>norman@google.com</td>
                    <td>2024-06-09</td>
                    <td>
                        <button>수정</button>
                        <button>삭제</button>
                    </td>
                </tr>
                <tr>
                    <td>Henri Pink</td>
                    <td>babodesu@google.com</td>
                    <td>2015-03-06</td>
                    <td>
                        <button>수정</button>
                        <button>삭제</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="button-group">
            <button>새 회원 추가</button>
            <button>Excel 다운로드</button>
        </div>
    </div>
</body>
</html>
