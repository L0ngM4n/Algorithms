package dynamicProgramming.lab1707;

/**
 * 16/08/2017
 */
final class Pair<T> {

  private final T left;
  private final T right;

  public Pair(T left, T right) {
    this.left = left;
    this.right = right;
  }

  public T getLeft() {
    return left;
  }

  public T getRight() {
    return right;
  }

  @Override
  public int hashCode() {
    return left.hashCode() ^ right.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pair))
      return false;
    Pair pair = (Pair)o;
    return this.left.equals(pair.getLeft()) && this.right.equals(pair.getRight());
  }

}
