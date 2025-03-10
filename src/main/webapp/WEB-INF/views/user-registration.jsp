<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="/user/register" method="POST">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required /><br><br>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required /><br><br>
        <button type="submit">Register</button>
    </form>
</body>
</html>
