(function() {
    angular.module('ldapApp.controllers',[])
    .controller('LdapListController',['$scope', '$state', 'popupService', 'Ldap',
        function($scope, $state, popupService, Ldap) {

            $scope.ldapList = Ldap.query();

            $scope.deleteLdap = function(ldap) {
                if(popupService.showPopup('Really delete this?')) {
                    ldap.$delete({uid: ldap.uid}, function() {
                        $scope.ldapList = Ldap.query();
                    });
                }
            }
    }])
    .controller('LdapViewController', ['$scope', '$stateParams', 'Ldap',
        function($scope, $stateParams, Ldap) {

            $scope.ldap = Ldap.get({uid:$stateParams.uid});

    }]).controller('LdapCreateController', ['$scope', '$state', '$stateParams', 'Ldap',
        function($scope, $state, $stateParams, Ldap) {

            $scope.ldap = new Ldap();

            $scope.saveLdap = function(ldap) {
                ldap.$save();
                $state.go('ldap');
            }

    }]).controller('LdapEditController',['$scope', '$state', '$stateParams', 'Ldap',
        function($scope, $state, $stateParams, Ldap) {

            $scope.saveLdap = function(ldap){
                ldap.$update({uid: ldap.uid}, function() {
                    $state.go('ldap');
                });
            };

            $scope.loadLdap = function(){
                $scope.ldap = Ldap.get({uid : $stateParams.uid});
            };

            $scope.loadLdap();

    }]);
})();