<?php
 
if($_SERVER['REQUEST_METHOD']=='POST'){
$username = $_POST['username'];
$password = $_POST['password'];
require_once('datakent_connection.php');
$sql = "SELECT * FROM login WHERE username = '$username' AND password='$password'";
$result = mysqli_query($con,$sql);
$check = mysqli_fetch_array($result);
if(isset($check)){
echo 'success';
}else{
echo 'Hatalı Giriş';
}
}

?>