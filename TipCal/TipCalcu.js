
		function calcTip() {
			var se = document.getElementById('subtotal');
			var tpe = document.getElementById('tip');
			var tote = document.getElementById('total');
			var subtotal = parseFloat(se.value);
			var tip = parseFloat(tpe.value);
			var total = subtotal * (1 + tip / 100);
			tote.innerHTML = '$' + total;
		}