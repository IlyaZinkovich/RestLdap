(function() {
    //'use strict';

    angular.module('ldapApp',['ui.router', 'ui.bootstrap','ngResource','ldapApp.controllers','ldapApp.services']);

    angular.module('ldapApp').config(function($stateProvider, $urlRouterProvider){
        $urlRouterProvider.otherwise('/ldap');
        $stateProvider.state('ldap',{
            url:'/ldap',
            templateUrl:'partials/ldap.html',
            controller:'LdapListController'
        }).state('viewLdap',{
           url:'/ldap/:uid/view',
           templateUrl:'partials/ldap-view.html',
           controller:'LdapViewController'
        }).state('newLdap',{
            url:'/ldap/new',
            templateUrl:'partials/ldap-save.html',
            controller:'LdapCreateController'
        }).state('editLdap',{
            url:'/ldap/:uid/edit',
            templateUrl:'partials/ldap-save.html',
            controller:'LdapEditController'
        });
    });

})();