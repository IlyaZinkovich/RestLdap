(function() {
    angular.module('ldapApp.services', [])
    .factory('Ldap', ['$resource', function($resource) {
        return $resource('http://localhost:8080/ldap/:id',
        {
            id:'@id'
        },
        {
            update: {
                method: 'PUT'
            }
        });
    }]).service('popupService', ['$window', function($window) {
        this.showPopup = function(message) {
            return $window.confirm(message);
        }
    }]);
})();
