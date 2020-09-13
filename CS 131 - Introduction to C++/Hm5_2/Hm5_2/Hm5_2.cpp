#include <iostream>

using namespace std;

bool isPrime(int);

int main()
{
	int number;
 
	cout << "Please Put the number which you want to clearfy : ";
	cin >> number;

	while (number < 1) // accpet only greater than 1
	{
		cout << "Please Put the number which is greater than 1 : ";
		cin >> number;
	}

	if (isPrime(number) == 1) // if the result is true output it is true. if is not output it is false.
		cout << "It is prime number " << endl;
	else if (isPrime(number) == 0)
		cout << "it is not prime number" << endl;

	system("pause");
	return 0;


}

bool isPrime(int num) // function that the number is prime number or not
{
	if (num == 2 | num == 3 | num == 5 | num == 7)
		return true;
	else if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0 && num % 7 != 0)
		return true;
	else
		return false;
}