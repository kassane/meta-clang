DESCRIPTION = "Zig toolchain and programming language"
HOMEPAGE = "http://ziglang.org/"
LICENSE = "MIT & Unknown"
SECTION = "devel"

SRC_URI = "git://github.com/ziglang/zig.git;branch=0.11.x;protocol=https"

# Modify these as desired
PV = "0.11.1"
SRCREV = "d9476605591750379bf45e759f419dba1ae98114"

S = "${WORKDIR}/git"
B = "${S}/build"

# NOTE: unable to map the following CMake package dependencies: llvm lld clang
# NOTE: the following library dependencies are unknown, ignoring: libcurses libzstd libz
#       (this is based on recipes that have previously been built and packaged)
inherit cmake native

do_compile() {
    make install
}
    
DEPENDS = "llvm-native clang"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release"

OECMAKE_GENERATOR = "Unix Makefiles"

# Use this in distro:
# LLVM_TARGETS_TO_BUILD = "AArch64;AMDGPU;ARM;AVR;BPF;Hexagon;Lanai;Mips;MSP430;NVPTX;PowerPC;RISCV;Sparc;SystemZ;VE;WebAssembly;X86;XCore"