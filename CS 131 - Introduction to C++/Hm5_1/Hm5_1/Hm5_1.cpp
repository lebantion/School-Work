#include <iostream>

using namespace std;

void kineticEnergy(double, double);

int main()
{
	double velocity, mass;

	cout << "How much is the velocity ? : ";  // set the value of velocity and mass
	cin >> velocity;
	cout << "How much is the mass? ? : ";
	cin >> mass;

	kineticEnergy(velocity, mass); // call fuction with the set up value

	system("pause");
	return 0;
}

void kineticEnergy(double vel, double mass)
{
	double KE;

	KE = pow(vel, 2)* mass / 2;
	cout << "Your Kinetic Energy is : " << KE << endl; // show the kinetic energy
}