
<script src="http://www.jq22.com/jquery/jquery-3.3.1.js"></script>
wel!


<form action="wel">
    <input name="lang" type="text">
    <input name="string" type="text">



    <input type="submit" value="提交">

</form>



<input type="button" id="json">


<!-- /request -->

<script>
    $('#json').click(function(){
        var obj={};
        obj.lang='12';
        obj.string='sss';
        $.ajax({
          data:JSON.stringify(obj),
          contentType:'application/json',
          type:'post',
          url:'/request',
          success:function(re){

          },
          error:function(err){
          }
        })

    })
</script>