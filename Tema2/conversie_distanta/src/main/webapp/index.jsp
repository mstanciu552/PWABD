<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversie distanta</title>
</head>
<body>
    <h1>Conversie distanta</h1>
    <form action="conversie" method="post">
        <label for="valoare-conversie">Valoare: </label><input type="text" name="valoare-conversie"><br><br>
        <select name="initial">
            <option value="metri">Metri</option>
            <option value="inch">Inch</option>
            <option value="feet">Feet</option>
        </select>   ------>
        <select name="final">
            <option value="metri">Metri</option>
            <option value="inch">Inch</option>
            <option value="feet">Feet</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>