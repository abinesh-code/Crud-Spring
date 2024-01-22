<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div align="center">
        <h1>Insert</h1>
        <form action="store" method="post">
            <input type="text" name="id" placeholder="Enter id"><br><br>
            <input type="text" name="name" placeholder="Enter name"><br><br>
            <input type="text" name="age" placeholder="Enter age"><br><br>
            <input type="submit" value="submit">
        </form>
        <h1>Read</h1>
        <form action="show" method="post">
            <input type="text" name="id" placeholder="Enter id">
            <input type="submit" value="submit">
        </form>
        <h1>Delete</h1>
        <form action="remove" method="post">
            <input type="text" name="id" placeholder="Enter id">
            <input type="submit" value="submit">
        </form>
        <h1>Update</h1>
        <form action="modify" method="post">
            <input type="text" name="id" placeholder="Enter id"><br><br>
            <input type="text" name="name" placeholder="Enter name"><br><br>
            <input type="text" name="age" placeholder="Enter age"><br><br>
            <input type="submit" value="submit">
        </form>
        <h1>Fetch All</h1>
        <form action="fetchAll" method="post">
            <input type="submit" value="submit">
        </form>
        <h1>Delete All</h1>
        <form action="removeAll" method="post">
            <input type="submit" value="submit">
        </form>
    </div>
</body>
</html>