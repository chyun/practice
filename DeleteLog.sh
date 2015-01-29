#!/bin/bash

#This script is used to delete logs when disk is not enough
exceed = `df -h|grep -c -E \([8-9][0-9]\%\)\|\(100\%\)`
if [$exceed -gt 0]
then
	#{} would be replaced by the file name , and '\' id used to escaped ';', exec would execute the command until encountered ';'
	logDir=$1
	find $logDir -mtime +2 -name "access*" -exec rm -f {} \;             
fi