#include <stdio.h>

int main()
{
	int	a;
	int	b;
	int	c;

	b = 1;
	c = 2;
	_asm
	{
		
		mov eax, b
		mul c
		mov a, ezx
	}
	return (0);
}
