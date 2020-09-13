#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	double selection, distance, time;
	cout << setprecision(4) << fixed << "1. Air" << endl;
	cout << "2. Water" << endl;
	cout << "3. Steel" << endl;
	cout << "Select Medium that you want to calculate : ";
	cin >> selection;

	if (selection == 1)
	{
		cout << "Please, Enter the distance that you want to calculate : ";
		cin >> distance;

		while (distance < 0)
		{
			cout << "Please, Enter the distance which is more than 0 : ";
			cin >> distance;
		}

		time = distance / 1100;
		
		cout << "The time by Air is : " << time << endl;
	}
	else if (selection == 2)
	{
		cout << "Please, Enter the distance that you want to calculate : ";
		cin >> distance;
		
		while (distance < 0)
		{
			cout << "Please, Enter the distance which is more than 0 : ";
			cin >> distance;
		}
		
		time = distance / 4900;
		
		cout << "The time by water is : " << time << endl;
	}
	else if (selection == 3)
	{
		cout << "Please, Enter the distance that you want to calculate : ";
		cin >> distance;
		
		while (distance < 0)
		{
			cout << "Please, Enter the distance which is more than 0 : ";
			cin >> distance;
		}

		time = distance / 16400;

		cout << "The time by Steel is : " << time << endl;
	}

	system("pause");
	return 0;
}