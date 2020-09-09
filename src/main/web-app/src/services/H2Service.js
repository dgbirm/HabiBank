import axios from 'axios';

const ROOT = '/api'
const HOST_NAME = 'http://localhost:8080'

//for testing
const CUST_REST_API_URL = 'http://localhost:8080/api/customers';
const ACCT_REST_API_URL = 'http://localhost:8080/api/accounts';
const TRANS_REST_API_URL = 'http://localhost:8080/api/transactions';

class H2Service {

    getCustomers(){
        return axios.get(CUST_REST_API_URL);
    }
    
    getRequest(dbName, perPage, currentPage){
        const queryURL = `${HOST_NAME}${ROOT}/${dbName}?page=${currentPage}&size=${perPage}`;
        console.log(queryURL)
        return axios.get(queryURL);
    }

    async onCreate(dbName, newEntry) {
        const queryURL = `${HOST_NAME}${ROOT}/${dbName}`;
        try {
            const response = await axios.post(queryURL, newEntry);
            console.log(response);
        }
        catch (error) {
            console.log(error);
        }
    }
}

export default new H2Service();