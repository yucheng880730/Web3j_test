package leo;

import okhttp3.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthEstimateGas;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;

public class main {

    private final static String PRIVATE_KEY = "<my private key>";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L); // L being long; capital for clarity

    public static void main(String[] args) {

        try {
            new main();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private main () throws Exception {

        System.out.println("Connecting to Ethereum ... ");

        // if you are running the Ganache application on your machine
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));
        System.out.println("Successfully connected to Ethereum");

        printWeb3Version(web3j);

        Credentials credentials = getCredentialsFromPrivateKey();
        System.out.println("Credential KeyPair : " + credentials.getEcKeyPair());

    }

    private void printWeb3Version(Web3j web3j){

        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String web3ClientVersionString = web3ClientVersion.getWeb3ClientVersion();
        System.out.println();
        System.out.println("Web3 client version: " + web3ClientVersionString);
        System.out.println();

    }

}
