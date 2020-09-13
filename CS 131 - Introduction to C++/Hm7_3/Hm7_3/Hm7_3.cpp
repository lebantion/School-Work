#include <iostream>

using namespace std;

const int SIZE = 5;
int function[SIZE] = { 1, 2, 3, 4, 5 };
int make_array(int[]);

int main()
{
	make_array(function);

	system("pause");
	return 0;
}

int make_array(int array[])
{
	int *ptr = &array[1];
	ptr = new int[SIZE + 1];
	ptr[0] = 0;
	for (int count = 1; count < SIZE + 1; count++)
	{
		ptr[count] = array[count - 1];
	}
	for (int count = 0; count < SIZE + 1; count++)
	{
		cout << ptr[count] << endl;
	}
	return *ptr;
}