package leo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
//import rx.Flowable;
//import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class ExampleContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610298806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c8063361ab84f1461003b57806338639f7b14610060575b600080fd5b61004e61004936600461018f565b610075565b60405190815260200160405180910390f35b61007361006e3660046101cc565b61009c565b005b600080826040516100869190610211565b9081526020016040518091039020549050919050565b806000836040516100ad9190610211565b90815260200160405180910390208190555080826040516100ce9190610211565b604051908190038120907f11fa40d38d8c12e6885f25dce1bff58b84fb756b4fbf3d70be7237df8c4569bc90600090a35050565b600082601f83011261011357600080fd5b813567ffffffffffffffff8082111561012e5761012e61024c565b604051601f8301601f19908116603f011681019082821181831017156101565761015661024c565b8160405283815286602085880101111561016f57600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000602082840312156101a157600080fd5b813567ffffffffffffffff8111156101b857600080fd5b6101c484828501610102565b949350505050565b600080604083850312156101df57600080fd5b823567ffffffffffffffff8111156101f657600080fd5b61020285828601610102565b95602094909401359450505050565b6000825160005b818110156102325760208186018101518583015201610218565b81811115610241576000828501525b509190910192915050565b634e487b7160e01b600052604160045260246000fdfea26469706673582212201e4c0150087a8ec4b69d1ade2685188877f9b4b1344d45d8678c22a1705d659d64736f6c63430008060033";

    public static final String FUNC_RETURNBALANCE = "returnBalance";

    public static final String FUNC_SETBALANCE = "setBalance";

    public static final Event SETBALANCEEVENT_EVENT = new Event("setBalanceEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected ExampleContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ExampleContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ExampleContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ExampleContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<SetBalanceEventEventResponse> getSetBalanceEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETBALANCEEVENT_EVENT, transactionReceipt);
        ArrayList<SetBalanceEventEventResponse> responses = new ArrayList<SetBalanceEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetBalanceEventEventResponse typedResponse = new SetBalanceEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.balance = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SetBalanceEventEventResponse> setBalanceEventEventObservable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Func1<Log, SetBalanceEventEventResponse>() {
            @Override
            public SetBalanceEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SETBALANCEEVENT_EVENT, log);
                SetBalanceEventEventResponse typedResponse = new SetBalanceEventEventResponse();
                typedResponse.log = log;
                typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.balance = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SetBalanceEventEventResponse> setBalanceEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETBALANCEEVENT_EVENT));
        return setBalanceEventEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> returnBalance(String _name) {
        final Function function = new Function(
                FUNC_RETURNBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setBalance(String _name, BigInteger _balance) {
        final Function function = new Function(
                FUNC_SETBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_balance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<ExampleContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ExampleContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ExampleContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ExampleContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ExampleContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ExampleContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ExampleContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ExampleContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static ExampleContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ExampleContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ExampleContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ExampleContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ExampleContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ExampleContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ExampleContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ExampleContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class SetBalanceEventEventResponse {
        public Log log;

        public byte[] name;

        public BigInteger balance;
    }
}
