#include <iostream>
#include <chrono>
#include "pid.hpp"

using namespace std::chrono;
double integralError, previousError;
high_resolution_clock::time_point previousTime;
double kp = 1.0;
double ki = 1.0;
double kd = 1.0;

void pid(double desiredHeight, double height){

	using namespace std::chrono;
	high_resolution_clock::time_point now = high_resolution_clock::now();
	
	duration<double> duration = (now-previousTime);
	double timeElapsed = duration.count();
	std::cout << timeElapsed;


	double error = desiredHeight - getHeight();
	integralError += (error * timeElapsed);
	double derivativeError = (error-previousError) / timeElapsed;

	double result = kp * error + ki * integralError + kd * derivativeError;
	
	setThrust(result);

	previousError = error;
	previousTime = now;

}

int main(){
	double desiredHeight;
	std::cout << "Desired Height: ";
	std::cin >> desiredHeight;

	/*
	* Code should start here.
	*/
	while(true){
	pid(desiredHeight, getHeight());
	}
}


