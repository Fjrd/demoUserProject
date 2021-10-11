Ext.define('Users.model.UsersModel', {
    extends: 'Ext.data.Model',

    requires: [
        'Ext.data.field.String'
    ],

    fields: [
        {
            type: 'string',
            name: 'id'
        },
        {
            type: 'string',
            name: 'firstName'
        },
        {
            type: 'string',
            name: 'middleName'
        },
        {
            type: 'string',
            name: 'lastName'
        },
        {
            type: 'string',
            name: 'email'
        },
        {
            type: 'string',
            name: 'password'
        }

        //ads

    ]

});