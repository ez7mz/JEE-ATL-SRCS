<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <link rel="stylesheet" type="text/css" href="sucstyles.css">
</head>
<body>
<div class="container">
    <h1>Registration Successful</h1>
    <p>Thank you for registering! Your account has been created successfully.</p>
</div>
<div class="card">
    <h2>Personal Information</h2>
    <ul>
        <li><strong>Full Name    : </strong> ${student.nom} ${student.prenom}</li>
        <li><strong>Birth Date   :</strong> ${student.dateDeNaissance}</li>
        <li><strong>CIN          :</strong> ${student.cin}</li>
        <li><strong>Phone        :</strong> ${student.numeroDeTelephone}</li>
        <li><strong>Email          :</strong> ${student.adresseEmail}</li>
    </ul>
</div>
<div class="container">
    <button onclick="location.href='index.html'">Return to Home</button>
</div>
</body>
</html>
