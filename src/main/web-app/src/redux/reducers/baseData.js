import {
  LOAD_ALL_ACCOUNTS,
  LOAD_ALL_CUSTOMERS,
  LOAD_ALL_TRANSACTIONS,
} from "../actions/actionTypes";

const initialState = {
  customers: {},
  accounts: {},
  transactions: {},
};

function baseDataReducer(state = initialState, action) {
  switch (action.type) {
    case LOAD_ALL_CUSTOMERS:
      return Object.assign({}, state, {
        customers: { ...state.customers, ...action.payload },
      });

    case LOAD_ALL_ACCOUNTS:
      return Object.assign({}, state, {
        accounts: { ...state.accounts, ...action.payload },
      });

    case LOAD_ALL_TRANSACTIONS:
      return Object.assign({}, state, {
        transactions: { ...state.transactions, ...action.payload },
      });

    default:
      return state;
  }
}

export default baseDataReducer;

/*
8080/api/accounts

{
   "content":[
      {
         "acctID":2,
         "acctBalance":90.0,
         "acctType":"CHECKING",
         "customers":[
            {
               "userName":"cj",
               "fullName":"Chris Jabb",
               "email":"fearandloathinginUSSR@aol.com",
               "address":"nowhere",
               "phoneNumber":"1233334545",
               "customerID":1
            }
         ]
      },
      {
         "acctID":4,
         "acctBalance":1000.0,
         "acctType":"BROKERAGE",
         "customers":[
            {
               "userName":"mk",
               "fullName":"Matty K",
               "email":"servethesovietunion@lol.com",
               "address":"everwhere",
               "phoneNumber":"2223334545",
               "customerID":3
            },
            {
               "userName":"db",
               "fullName":"Danny B",
               "email":"danny@netscape.com",
               "address":"somewhere",
               "phoneNumber":"693334545",
               "customerID":5
            }
         ]
      },
      {
         "acctID":7,
         "acctBalance":1000000.0,
         "acctType":"SAVINGS",
         "customers":[
            {
               "userName":"nn",
               "fullName":"Natasha Ng",
               "email":"nn@yahoo.com",
               "address":"Seattle",
               "phoneNumber":"3123334545",
               "customerID":6
            }
         ]
      }
   ],
   */
