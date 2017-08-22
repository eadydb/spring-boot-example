/**
 * Created by eadydb on 17-5-4.
 */

$('#kaptchaImage').click(function () {
    $(this).attr('src', '/kaptcha/image?' + Math.floor(Math.random() * 100));
});