public class CuentaCorriente extends Cuenta {

    private final double limiteSobregiro;

    public CuentaCorriente(
            String titular,
            double saldoInicial,
            double limiteSobregiro) {

        super(titular, saldoInicial);

        if (limiteSobregiro < 0) {
            throw new IllegalArgumentException(
                    "El límite de sobregiro no puede ser negativo."
            );
        }

        this.limiteSobregiro = limiteSobregiro;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    @Override
    public void retirar(double monto)
            throws ExcepcionBancaria {

        validarMonto(monto);
        validarCuentaActiva();

        double saldoDisponible =
                getSaldo() + limiteSobregiro;

        if (monto > saldoDisponible) {
            throw new FondosInsuficientesException(
                    "El retiro supera el límite de sobregiro."
            );
        }

        disminuirSaldo(monto);
    }
}
