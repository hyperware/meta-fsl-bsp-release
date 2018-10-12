FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
require xen.inc

SRCBRANCH = "imx_4.14.62_1.0.0_beta"
XEN_SRC ?= "git://source.codeaurora.org/external/imx/imx-xen.git;protocol=https"

SRC_URI = " \
    ${XEN_SRC};branch=${SRCBRANCH} \
    file://tools-libxc-fix-strncpy-size.patch \
    file://tools-misc-fix-hypothetical-buffer-overflow.patch \
    file://tools-xentop-vwprintw.patch \
    file://tools-xenpmd-fix-possible-0-truncation.patch \
    file://tools-gdbsx-fix-Wstringop-truncation-warning.patch \
    file://tools-kdd-mute-spurious-gcc-warning-part1.patch \
    file://tools-kdd-mute-spurious-gcc-warning-part2.patch \
    file://shim-don-t-let-build-modify-shim.config.patch \
    "

SRCREV = "9240b9351175900ceb732718cd58bcc89329cd60"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "${@bb.utils.contains('MACHINE_FEATURES', 'xen', '${MACHINE}', '(^$)', d)}"