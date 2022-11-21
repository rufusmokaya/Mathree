<?php
include("initm.php") ;
    $gottenFname =$_POST['firstname'];
	$gottenSname =$_POST['secondname'];
	$gottenUsername =$_POST['username'];
	$gottenGender =$_POST['gender'];
	$gottenBusComp =$_POST['buscompany'];
	$gottenRoute =$_POST['route'];
	$gottenPhone =$_POST['phone'];
	$gottenPassword =$_POST['password'];
	$gottenNumberPlate =$_POST['numberplate'];
	$selectQuery="SELECT * FROM conductordetails WHERE phone like '".$gottenPhone."';"; 
	$selectResults = mysqli_query($connection,$selectQuery); 
	$response = array();
	if(mysqli_num_rows($selectResults)>0)
	{
		$code = "reg_failed";
		$message = "User already exists";
		array_push($response, array("code"=>$code,"message"=>$message));
		echo json_encode($response);
	}
	else
	{
		$selectQuery= "INSERT INTO conductordetails(firstname,secondname,username,gender,buscompany,route,phone,password,numberplate) VALUES('".$gottenFname."','".$gottenSname."','".$gottenUsername."','".$gottenGender."','".$gottenBusComp."','".$gottenRoute."','".$gottenPhone."','".$gottenPassword."','".$gottenNumberPlate."');";
		$selectResults = mysqli_query($connection,$selectQuery)or die(mysqli_error($connection));
		$code = "reg_success";
		$message = "Thank you for registering for Mathree as a Conductor";
		array_push($response, array("code"=>$code,"message"=>$message));
		echo json_encode($response);
	}
mysqli_close($connection);
?>