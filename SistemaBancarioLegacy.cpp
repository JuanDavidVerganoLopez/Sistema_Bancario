#include <iostream>
#include <fstream>
#include <string>

// Los atributos son públicos por defecto en un struct.
// Cualquier parte del programa puede modificar directamente
// el saldo, titular, tipo de cuenta, etc.

struct CuentaLegacy {

    // Puntero crudo que apunta a memoria dinámica.
    // No queda claro quién es responsable de liberarla.
    char* titular;

    // Cualquier módulo puede modificar el saldo directamente.
    double saldo;

    // Se utiliza un entero para representar el tipo de cuenta.
    // Esto obliga posteriormente a utilizar if/else o switch.
    //
    // 1 = Ahorros
    // 2 = Corriente
    int tipoCuenta;

    // También puede modificarse directamente sin validar
    // las reglas de negocio.
    double limiteSobregiro;
};


CuentaLegacy* crearCuenta(
    const char* nombre,
    double saldoInicial,
    int tipo
) {


    // Se reserva memoria manualmente con new.
    // Esta memoria tendrá que ser liberada posteriormente
    // con delete. Si el programa pierde este puntero,
    // se produce una FUGA DE MEMORIA.
    CuentaLegacy* c = new CuentaLegacy();



    // Segunda reserva dinámica.
    c->titular = new char[50];


    // strcpy() no conoce el tamaño de la memoria reservada.
    strcpy(c->titular, nombre);


    // No se comprueba si saldoInicial es válido.
    c->saldo = saldoInicial;


    // El tipo de cuenta se representa mediante un int.
    c->tipoCuenta = tipo;


    // La lógica de negocio depende directamente del valor
    // numérico del tipo de cuenta.
    c->limiteSobregiro =
        (tipo == 2) ? 500.0 : 0.0;


    // Se devuelve un puntero crudo.
    return c;
}
