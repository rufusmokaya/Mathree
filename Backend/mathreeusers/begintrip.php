<?php
include("initm.php") ;
    $gottenUsername =$_POST['username'];
    $gottenStartLong =$_POST['starting_long'];
	$gottenStartLat =$_POST['start_lat'];
	$gottenPhone =$_POST['phonenumber'];
	$response = array();

	$selectQuery= "INSERT INTO begintrip(username,starting_long,start_lat,phonenumber) VALUES('".$gottenUsername."','".$gottenStartLong."','".$gottenStartLat."','".$gottenPhone."','".$gottenBusComp."');";
$selectQuery = mysqli_query($connection,$selectQuery);
if($selectQuery)
{
	    $code = "success";
		$message = "Sent, you will be picked up shortly";
		array_push($response, array("code"=>$code,"message"=>$message));
		echo json_encode($response);
	

}
else
{
	    $code = "error";
		$message = "";
		array_push($response, array("code"=>$code,"message"=>$message));
		echo json_encode($response);
	

}
mysqli_close($connection);
	



?>