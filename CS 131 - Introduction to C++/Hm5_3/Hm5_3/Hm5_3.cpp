#include <iostream>

using namespace std;

void inpatient();
void outpatient();

int main()
{
	int menu;

	cout << "1. inpatient fee." << endl; // make menu so that ask user to choose in or out.
	cout << "2. outpatient fee." << endl;
	cout << "Please, Enter the number which you want to know : ";
	cin >> menu;

	while (menu != 1 && menu != 2) // make sure that user put right number
	{
		cout << "Please, Enter the 1 or 2..." << endl;
		cout << "Please, Enter the number which you want to know : ";
		cin >> menu;
	}

	
	if (menu == 1) // inpatient fee
	{
		inpatient();
	}
	else if (menu == 2) // outpatient fee
	{
		outpatient();
	}
	system("pause");
	return 0;
}

void inpatient()
{
	int days;
	double daily, medication, hospital, total;

	medication = 50;
	hospital = 100;
	

	cout << "How many days did you spend? : "; // ask day
	cin >> days;
	cout << "What is daily rate ? : "; // ask daily rate
	cin >> daily;

	while (days < 1 || daily < 0) // make sure user not to put negative value
	{
		cout << "Please Enter the positive value of day and daily rate..." << endl;
		cout << "How many days did you spend? : ";
		cin >> days;
		cout << "What is daily rate ? : ";
		cin >> daily;
	}
	total = days * daily + medication + hospital; // get total

	cout << "Your total is : " << total << "$ " << endl; // output total
}

void outpatient()
{
	double medication, hospital, total;

	medication = 50;
	hospital = 100;
	total = medication + hospital; // get total
	cout << "Your total is : " << total << "$" << endl; // output total
}