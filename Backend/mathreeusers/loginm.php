<?php
include('initm.php');
$gottenUsername =$_POST['username'];
$gottenPassword =$_POST['password'];


$selectQuery ="SELECT firstname,secondname,username, phone from customerusers WHERE username = '".$gottenUsername."' AND password = '".$gottenPassword."'";
$selectResults = mysqli_query($connection,$selectQuery)or die(mysqli_error($connection)); 
$response =array();
if(mysqli_num_rows($selectResults)>0)
	{
		/*$row = mysqli_fetch_row($selectResults);*/
		/*$name1 = $row[0];
		$name2 = $row[1];
		$response['message'] = "You will be logged in shortly";
		$response['code'] = "login_success";
		
		$res = mysqli_query($connection, "SELECT * from customerusers WHERE username = '".$gottenUsername."' AND password = '".$gottenPassword."'");
		$response['data'] = mysqli_fetch_assoc($res);
		*/
		$row = mysqli_fetch_row($selectResults);

		$name3 = $row[0];
		$name2 = $row[2];
		$phone = $row[3];
		$name4 = $row[1];
		 
		$code = "login_success";
		array_push($response, array("code"=>$code,"username"=>$name2,"phone"=>$phone,"firstname"=>$name3,"secondname"=>$name4));
		echo json_encode($response);
	}
	else
	{
		$code = "login_failed";
		$message = "User not found";
		array_push($response, array("code"=>$code,"message"=>$message));

		echo json_encode($response);
		
	}

//secho json_encode($response);
mysqli_close($connection);
?>