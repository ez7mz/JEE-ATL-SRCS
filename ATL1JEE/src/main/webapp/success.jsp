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
        <li><strong>Full Name    : </strong> ${student.name}</li>
        <li><strong>Birth Date   :</strong> ${student.date}</li>
        <li><strong>CIN          :</strong> ${student.cin}</li>
        <li><strong>Phone Number :</strong> ${student.phone}</li>
        <li><strong>Address      :</strong> ${student.address}</li>
        <li><strong>Email        :</strong> ${student.email}</li>
        <li><strong>Registration :</strong> ${regDate}</li>
        <li><strong>Filier       :</strong> ${filier}</li>
        <li><strong>Group        :</strong> ${group}</li>
        <li><strong>Niveau       :</strong> ${niveau}</li>
    </ul>
</div>
<div class="container">
    <button onclick="location.href='index.html'">Return to Home</button>
</div>
</body>
</html>
