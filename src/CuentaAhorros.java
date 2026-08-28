public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void retirar(double monto)
            throws ExcepcionBancaria {

        validarMonto(monto);
        validarCuentaActiva();

        if (monto > getSaldo()) {
            throw new FondosInsuficientesException(
                    "Fondos insuficientes."
            );
        }

        disminuirSaldo(monto);
    }
}
