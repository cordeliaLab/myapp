if(typeof jQuery == "function"){
    $(document).ajaxStart(function () {
        // console.log('loding start');
        // TargetLodingImg.start();
    })
    $(document).ajaxStop(function () {
        // console.log('loding stop');
        // TargetLodingImg.stop();
    })
}

TargetLodingImg = {
    loadingHTML : function () {
        return "<div class='loading display_none'>잠시만 기다려주세요..</div>";
    },
    start: function (targetSelector) {
        // $(".loading").css({display:'block'});

        // 로딩 보여줄 곳 선택
        let el_target = $(targetSelector);
        // 로딩 보여줄 곳 안에 로딩 html 넣기
        el_target.append(this.loadingHTML());
        // 부모의 position 을 찾기
        let target_pos = el_target.css('position');
        // 부모의 포지션이 기본 값이면
        if (target_pos === 'static') {
            // 부모를 relative 로 변경 해서 팝업이 잘 나오도록 함
            // 참고로 fixed 값은 화면기준이고 absolute는 부모의 영향을 받음
            el_target.css({position: 'relative'});
        }
        // display_none 클래스를 삭제 해서 로딩 노출
        $(".loading").removeClass('display_none');
    },
    stop: function (targetSelector) {
        // $(".loading").css({display:'none'});

        let load = $(".loading");
        // display_none 클래스를 추가해서 안보여줌
        load.addClass('display_none');
        // 삭제
        load.remove();
    }
}
