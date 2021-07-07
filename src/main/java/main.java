import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthEstimateGas;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class main {

    public static void main(String[] args) {

        System.out.println("Connecting to Ethereum ... ");

        // if you are running the Ganache application on your machine
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));
        System.out.println("Successfully connected to Ethereum");

        try {

            // web3_clientVersion returns the current client version.
            Web3ClientVersion clientVersion = web3j.web3ClientVersion().send();

            // eth_blockNumber returns the number of most recent block.
            EthBlockNumber blockNumber = web3j.ethBlockNumber().send();

            // eth_gasPrice, returns the current price per gas in wei.
            EthGasPrice gasPrice = web3j.ethGasPrice().send();

            // Print result
            System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
            System.out.println("Block number: " + blockNumber.getBlockNumber());
            System.out.println("Gas price: " + gasPrice.getGasPrice());

        } catch (IOException ex) {

            throw new RuntimeException("Error whilst sending json-rpc requests", ex);

        }

    }
}
