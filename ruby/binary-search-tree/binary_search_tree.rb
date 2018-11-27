class Bst
  attr_reader :data, :right, :left

  def initialize(data)
    @data = data
    @right = nil
    @left = nil
  end

  def insert(new_data)
  	if new_data <= @data
      left? ? @left.insert(new_data) : @left = Bst.new(new_data)
    elsif new_data > @data
      right? ? @right.insert(new_data) : @right = Bst.new(new_data)
    end
  end

  def each(&block)
    to_enum.each(&block)
  end

  def left?
    !@left.nil?
  end

  def right?
    !@right.nil?
  end

  private

  def to_enum
    Enumerator.new do |func|
      @left.each { |child| func << child } if left?
      func << @data
      @right.each { |child| func << child } if right?
    end
  end
end
