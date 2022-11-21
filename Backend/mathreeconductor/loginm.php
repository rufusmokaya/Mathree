<?php
include('initm.php');
$gottenUsername =$_POST['username'];
$gottenPassword =$_POST['password'];
$selectQuery ="SELECT firstname, phone, numberplate,username from conductordetails WHERE username like '".$gottenUsername."' and password like '".$gottenPassword."'";
$selectResults = mysqli_query($connection,$selectQuery); 
$response =array();
if(mysqli_num_rows($selectResults)>0)
	{
		$row = mysqli_fetch_row($selectResults);
		$name2 = $row[0];
		$phone = $row[1];
		$numberplate =$row[2]; 
		$username = $row[3];
		$code = "login_success";
		array_push($response, array("code"=>$code,"firstname"=>$name2,"phone"=>$phone,"numberplate"=>$numberplate,"username"=>$username));
		echo json_encode($response);
	}
	else
	{
		$code = "login_failed";
		$message = "User not found";
		array_push($response, array("code"=>$code,"message"=>$message));

		echo json_encode($response);
	}
mysqli_close($connection);
?>