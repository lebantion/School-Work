#include <iostream>

using namespace std;
void making_array(const int);

int main()
{
	int num_students;

	cout << "How many students did you survey? : ";
	cin >> num_students;

	making_array(num_students);

	system("pause");
	return 0;

}

void making_array(const int num)
{
	double *ptr;
	double average, total;
	total = 0;
	ptr = new double[num];
	for (int count = 0; count < num; count++)
	{
		cout << "Put the number of movies that Student # " << count + 1 << " Watched :";
		cin >> ptr[count];
	}
	for (int count = 0; count < num; count++)
	{
		total += ptr[count];
	}
	average = total / num;

	cout << "Your Average is : " << average << endl;

}

