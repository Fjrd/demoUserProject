Ext.define('client.view.main.UsersList', {
    extend: 'Ext.grid.Panel',
    xtype: 'userslist',

    requires: [
        'client.store.UsersStore'
    ],

    title: 'Users',

    store: {
        type: 'usersStore'
    },

    columns: [
        { text: 'id',  dataIndex: 'id' },
        { text: 'firstName', dataIndex: 'firstName', flex: 1 },
        { text: 'middleName', dataIndex: 'middleName', flex: 1 },
        { text: 'lastName', dataIndex: 'lastName', flex: 1 },
        { text: 'email', dataIndex: 'email', flex: 1 },
        { text: 'password', dataIndex: 'password', flex: 1 },
        { text: 'ads', dataIndex: 'ads', flex: 1 }
        //ads
    ],

    listeners: {
        select: 'onItemSelected'
    }
});
