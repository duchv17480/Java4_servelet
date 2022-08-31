const app = angular.module("myApp",['ngRoute']);


app.config(function ($routeProvider,$locationProvider) {
    $locationProvider.hashPrefix("");
    $routeProvider
        .when("/trangchu",{
            templateUrl: 'trangchu.html',
            controller: 'trangchuController'
        })
        .when("/gioithieu",{
            templateUrl: 'gioithieu.html',
            controller: 'gioithieuController'
        })
        .when("/lienhe",{
            templateUrl: 'lienhe.html',
            controller: 'lienheController'
        })
        .when("/gopy",{
            templateUrl: 'gopy.html',
            controller: 'gopyController'
        })
        .when("/hoidap",{
            templateUrl: 'hoidap.html',
            controller: 'hoidapController'
        })
        .when("/danhmucmonhoc",{
            templateUrl: 'danhmucmonhoc.html',
            controller: 'danhmucmonhocController'
        })
        .when("/thitracnhiem",{
            templateUrl: 'thitracnhiem.html',
            controller: 'thitracnhiemController'
        })
        .otherwise({
            redirectTo: 'trangchu.html'
        })
        
})


app.controller("trangchuController",function ($scope,$http){
    $http.get('db/Subjects.js').then(function (res) {
        $scope.list_subject = [];
        $scope.list_subject = res.data ;
    })
})
app.controller("gioithieuController",function ($scope,$http){
    $http.get('db/Subjects.js').then(function (res) {
        $scope.list_subject = [];
        $scope.list_subject = res.data ;
    })
})
app.controller("lienheController",function ($scope,$http){
    $http.get('db/Subjects.js').then(function (res) {
        $scope.list_subject = [];
        $scope.list_subject = res.data ;
    })
})
app.controller("gopyController",function ($scope,$http){
    $http.get('db/Subjects.js').then(function (res) {
        $scope.list_subject = [];
        $scope.list_subject = res.data ;
    })
})
app.controller("hoidapController",function ($scope,$http){
    $http.get('db/Subjects.js').then(function (res) {
        $scope.list_subject = [];
        $scope.list_subject = res.data ;
    })
})
app.controller("danhmucmonhocController",function ($scope,$http){
    $http.get('db/Subjects.js').then(function (res) {
        $scope.list_subject = [];
        $scope.list_subject = res.data ;
    })
})
app.controller("thitracnhiemController",function ($scope,$http){
    $http.get('db/Subjects.js').then(function (res) {
        $scope.list_subject = [];
        $scope.list_subject = res.data ;
    })
})















app.controller("studentCtrl",function ($scope,$http,$rootScope) {
    $scope.login = function (){
        const API = 'http://62132052f43692c9c6faad8e.mockapi.io/api/user';
        $http.get(API).then(function (response){
            console.log(response);
            $rootScope.students = response.data ;
        });

        var lg =true ;
        $rootScope.students.forEach(st => {
            if (st.username == $scope.username) {
                if (st.password == $scope.password) {
                    $rootScope.indexStudent = st.index;
                    $rootScope.student = st;
                    lg = false;
                    return;
                };
            };
            });
            if (lg == false ) {
                alert('Đăng nhập thành công');
                window.location.href = "#danhmucmonhoc";
            }else{
                alert('Đăng nhập thất bại');
            }

        }
})









app.directive('quizfpoly',function (quizService) {
    return{
        restrict : 'AE',
        scope:{},
        templateUrl: 'tracnghiem.html',
        link: function (scope ,elem ,attr) {
            scope.start = function(){
                scope.quizOver = false ;//Chưa hoàn thành
                scope.id = 1 ;
                scope.inProgress = true ;
                scope.getQuestion();
            };
            scope.reset = function () {
                scope.inProgress = false ;
                scope.score = 0 ;
            };
            scope.getQuestion = function(){
                var quiz = quizService.getQuestion(scope.id);
                if(quiz){
                    scope.question = quiz.Text ;
                    scope.answers = quiz.Answers;
                    scope.answerId = quiz.AnswerId;
                    scope.answerMode = true;
                }else{
                    scope.quizOver = true ;
                }
            }

            scope.checkAnswer = function () {
                if(!$('input[name = answer]:checked').length) return ;
                
                var ans = $('input[name = answer]:checked').val();
                if(ans == scope.answerId){
                    scope.score++;
                    scope.correctAnswer = true ;
                }else{
                    scope.correctAnswer = false ;
                }
                scope.answerMode = false;
            }
            scope.nextQuestion = function(){
                scope.id++;
                scope.getQuestion();
            }
            scope.reset() ;
        }
    }
});




app.service('quizService',function ($http) {
    $http.get('db/Quizs/ADAV.js').then(function(res) {
        questions = res.data ;
    });
    return {
        getQuestion:function(id) {
            var count = questions.length;
            var randomItem = questions[Math.floor(Math.random() * count)];
            if(count > 10){
                count = 10 ;
            }
            if(id < count){
                return randomItem;
            }else{
                return false ;
            }
        }
    } 
})






