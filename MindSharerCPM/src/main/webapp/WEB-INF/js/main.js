/**
 * Created by 깔루 on 14. 4. 1.
 */
'use strict';
//requireJS 기본 설정 부분
requirejs.config({

	baseUrl:'',

	paths:{

		//뒤에 js 확장자는 생략한다.
		'text': 'lib/require/text', //HTML 데이터를 가져올때 text! 프리픽스를 붙여준다
		'angular': 'lib/angular/angular',
        'onsen' : 'lib/onsen/js/onsenui',
        'app' : 'js/app'
	},

	shim:{
		'angular':{
			exports:'angular'
		},
        'onsen':{
            deps :  ['angular']
        },
        'app':{
            deps: ['angular']
        }
	}
});

requirejs(['angular',
          'onsen',
          'app'
          ],

    function(nAngular ,onsen , $){
        console.log ("bootstrap");
        nAngular.bootstrap(document, ['myApp']);
});