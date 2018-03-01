package enums.caffee.algorithms.base;

import java.util.*;
import enums.caffee.*;

public interface CoinChangeable {
	public Collection<CoinCounter> change(Collection<Coin> coins);
}
