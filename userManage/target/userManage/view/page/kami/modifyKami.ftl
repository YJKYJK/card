
<div class="input-group centers" style="width: 80%">
    <form class="form-horizontal" id="modifyKami"   role="form" method="post">
        <input hidden name="cardId" value="${g.cardId}">
        <div class="input-group tops" >
            <span class="input-group-addon">卡号</span>
            <input type="text" name="cardNumber" value="${g.cardNumber}"  id="userName" class="form-control nu"
                   placeholder="卡号">
        </div>
        <div class="input-group tops">
            <span class="input-group-addon">卡密</span>
            <input type="text" name="cardPassword" value="${g.cardPassword}" class="form-control nu" placeholder="卡密">
        </div>
    </form>
</div>



