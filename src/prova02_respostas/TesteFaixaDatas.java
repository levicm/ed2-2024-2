package prova02_respostas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TesteFaixaDatas {

	public static class Obj {
		LocalDate d1;
		LocalDate d2;

		public Obj(LocalDate d1, LocalDate d2) {
			super();
			this.d1 = d1;
			this.d2 = d2;
		}

		public Obj() {
			// TODO Auto-generated constructor stub
		}

		public LocalDate getDataInicio() {
			return d1;
		}

		public LocalDate getDataFim() {
			return d2;
		}

		@Override
		public String toString() {
			return "Obj [d1=" + d1 + ", d2=" + d2 + "]";
		}
	}

	public static void main(String[] args) {

		List<Obj> itens = new ArrayList<Obj>();
		itens.add(new Obj(LocalDate.of(2023, 03, 04), LocalDate.of(2024, 03, 03)));
		itens.add(new Obj(LocalDate.of(2024, 03, 04), LocalDate.of(2025, 03, 01)));

		LocalDate esteMes = LocalDate.now().withDayOfMonth(1);

		Obj obj = itens.stream()
				.filter(c -> !esteMes.isBefore(c.getDataInicio().withDayOfMonth(1))
						&& (c.getDataFim() == null || !esteMes.isAfter(c.getDataFim().withDayOfMonth(1))))
				.findFirst().orElse(null);

		System.out.println(obj);
	}

}
